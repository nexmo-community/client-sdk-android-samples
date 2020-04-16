package com.vonage.sample.channel.messaging;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.*;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;

import java.util.Collection;

public class LoadConversationEventsActivityJava extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // new NexmoClient.Builder().build(this);
        NexmoClient client = NexmoClient.get();
        client.login("JWT token");
        getConversation(client);
    }

    private void getConversation(NexmoClient client) {
        client.getConversation("CONVERSATION_ID", new NexmoRequestListener<NexmoConversation>() {
            @Override
            public void onSuccess(@Nullable NexmoConversation nexmoConversation) {
                Timber.d("Conversation loaded");
            }

            @Override
            public void onError(@NonNull NexmoApiError apiError) {
                Timber.d("Error: Unable to load conversation %s", apiError.getMessage());
            }
        });
    }

    private void getConversationEvents(NexmoConversation conversation) {
        conversation.getEvents(100, NexmoPageOrder.NexmoMPageOrderAsc, new NexmoRequestListener<NexmoEventsPage>() {
            @Override
            public void onSuccess(@Nullable NexmoEventsPage eventsPage) {
                processEvents(eventsPage.getPageResponse().getData());
            }

            @Override
            public void onError(@NonNull NexmoApiError apiError) {
                Timber.d("Error: Unable to load conversation events %s", apiError.getMessage());
            }
        });
    }

    private void processEvents(Collection<NexmoEvent> events) {
        for (NexmoEvent event : events) {
            String message = "";

            if (event instanceof NexmoMemberEvent) {
                NexmoMemberEvent memberEvent = (NexmoMemberEvent) event;
                message = getEventText(memberEvent);
            }
            if (event instanceof NexmoTextEvent) {
                NexmoTextEvent textEvent = (NexmoTextEvent) event;
                message = getEventText(textEvent);
            }
            if (event instanceof NexmoSeenEvent) {
                NexmoSeenEvent seenEvent = (NexmoSeenEvent) event;
                message = getEventText(seenEvent);
            }
            if (event instanceof NexmoDeliveredEvent) {
                NexmoDeliveredEvent deliveredEvent = (NexmoDeliveredEvent) event;
                message = getEventText(deliveredEvent);
            }
            if (event instanceof NexmoTypingEvent) {
                NexmoTypingEvent typingEvent = (NexmoTypingEvent) event;
                getEventText(typingEvent);
            } else {
                message = "Unsupported event " + event.getEventType();
            }

            Timber.d(message);
        }
    }

    private String getEventText(NexmoTypingEvent typingEvent) {
        String user = typingEvent.getFromMember().getUser().getName();
        String typingState;

        if (typingEvent.getState() == NexmoTypingState.ON) {
            typingState = "typing";
        } else {
            typingState = "not typing";
        }

        return user + " is " + typingState;
    }

    private String getEventText(NexmoDeliveredEvent deliveredEvent) {
        String user = deliveredEvent.getFromMember().getUser().getName();
        return "Event from " + user + " with id " + deliveredEvent.initialEventId() + " delivered at " + deliveredEvent.initialEventId();
    }

    private String getEventText(NexmoSeenEvent seenEvent) {
        String user = seenEvent.getFromMember().getUser().getName();
        return user + " saw event with id " + seenEvent.initialEventId() + " at " + seenEvent.getCreationDate();
    }

    private String getEventText(NexmoTextEvent textEvent) {
        String user = textEvent.getFromMember().getUser().getName();
        return user + " said: " + textEvent.getText();
    }

    private String getEventText(NexmoMemberEvent memberEvent) {
        String user = memberEvent.getMember().getUser().getName();
        String event = memberEvent.getState().name();
        return user + " " + event;
    }
}
