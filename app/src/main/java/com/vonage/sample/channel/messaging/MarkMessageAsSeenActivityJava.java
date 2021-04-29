package com.vonage.sample.channel.messaging;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoAttachmentEvent;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoConversation;
import com.nexmo.client.NexmoDeletedEvent;
import com.nexmo.client.NexmoDeliveredEvent;
import com.nexmo.client.NexmoMessageEventListener;
import com.nexmo.client.NexmoSeenEvent;
import com.nexmo.client.NexmoTextEvent;
import com.nexmo.client.NexmoTypingEvent;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;

public class MarkMessageAsSeenActivityJava extends AppCompatActivity {

    private NexmoMessageEventListener messageListener = new NexmoMessageEventListener() {
        @Override
        public void onTextEvent(@NonNull NexmoTextEvent textEvent) {
            textEvent.markAsSeen(markAsSeemListener);
        }

        @Override
        public void onAttachmentEvent(@NonNull NexmoAttachmentEvent attachmentEvent) {}

        @Override
        public void onEventDeleted(@NonNull NexmoDeletedEvent deletedEvent) {}

        @Override
        public void onSeenReceipt(@NonNull NexmoSeenEvent seenEvent) {}

        @Override
        public void onDeliveredReceipt(@NonNull NexmoDeliveredEvent deliveredEvent) {}

        @Override
        public void onTypingEvent(@NonNull NexmoTypingEvent typingEvent) {}
    };

    private NexmoRequestListener markAsSeemListener = new NexmoRequestListener() {
        @Override
        public void onSuccess(@Nullable Object o) {
            Timber.d("Message marked as seen");
        }

        @Override
        public void onError(@NonNull NexmoApiError apiError) {
            Timber.d("Error: Unable to mark message as seen %s", apiError.getMessage());
        }
    };

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
            public void onSuccess(@Nullable NexmoConversation conversation) {
                Timber.d("Conversation loaded");
                conversation.addMessageEventListener(messageListener);
            }

            @Override
            public void onError(@NonNull NexmoApiError apiError) {
                Timber.d("Error: Unable to load conversation %s", apiError.getMessage());
            }
        });
    }
}
