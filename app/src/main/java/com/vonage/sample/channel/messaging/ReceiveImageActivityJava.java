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

public class ReceiveImageActivityJava extends AppCompatActivity {

    private NexmoMessageEventListener messageListener = new NexmoMessageEventListener() {
        @Override
        public void onTextEvent(@NonNull NexmoTextEvent nexmoTextEvent) {}

        @Override
        public void onAttachmentEvent(@NonNull NexmoAttachmentEvent nexmoAttachmentEvent) {}

        @Override
        public void onEventDeleted(@NonNull NexmoDeletedEvent nexmoDeletedEvent) {}

        @Override
        public void onSeenReceipt(@NonNull NexmoSeenEvent nexmoSeenEvent) {}

        @Override
        public void onDeliveredReceipt(@NonNull NexmoDeliveredEvent nexmoDeliveredEvent) {}

        @Override
        public void onTypingEvent(@NonNull NexmoTypingEvent nexmoTypingEvent) {}
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
