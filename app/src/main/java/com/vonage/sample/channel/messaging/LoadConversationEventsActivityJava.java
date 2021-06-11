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

    private NexmoRequestListener<NexmoEventsPage> conversationEventsListener = new NexmoRequestListener<NexmoEventsPage>() {
        @Override
        public void onSuccess(@Nullable NexmoEventsPage eventsPage) {
            processEvents(eventsPage.getData());
        }

        @Override
        public void onError(@NonNull NexmoApiError apiError) {
            Timber.d("Error: Unable to load conversation events %s", apiError.getMessage());
        }
    };

    private NexmoRequestListener<NexmoConversation> getConversationListener = new NexmoRequestListener<NexmoConversation>() {
        @Override
        public void onSuccess(@Nullable NexmoConversation conversation) {
            conversation.getEvents(100, NexmoPageOrder.NexmoMPageOrderAsc, null, conversationEventsListener);
        }

        @Override
        public void onError(@NonNull NexmoApiError apiError) {
            Timber.d("Error: Unable to load conversation %s", apiError.getMessage());
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // new NexmoClient.Builder().build(this);
        NexmoClient client = NexmoClient.get();
        client.login("JWT token");
        client.getConversation("CONVERSATION_ID", getConversationListener);
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

    private String getEventText(NexmoTypingEvent event) {
        String fromMemberId = event.getFromMemberId();
        String typingState;

        if (event.getState() == NexmoTypingState.ON) {
            typingState = "typing";
        } else {
            typingState = "not typing";
        }

        return fromMemberId + " is " + typingState;
    }

    private String getEventText(NexmoDeliveredEvent event) {
        String fromMemberId = event.getFromMemberId();
        return "Event from " + fromMemberId + " with id " + event.initialEventId() + " delivered at " + event.initialEventId();
    }

    private String getEventText(NexmoSeenEvent event) {
        String fromMemberId = event.getFromMemberId();
        return fromMemberId + " saw event with id " + event.initialEventId() + " at " + event.getCreationDate();
    }

    private String getEventText(NexmoTextEvent event) {
        String fromMemberId = event.getFromMemberId();
        return fromMemberId + " said: " + event.getText();
    }

    private String getEventText(NexmoMemberEvent event) {
        String fromMemberId = event.getFromMemberId();
        return fromMemberId + " invited by" + event.getInvitedBy() + " " + event;
    }
}
