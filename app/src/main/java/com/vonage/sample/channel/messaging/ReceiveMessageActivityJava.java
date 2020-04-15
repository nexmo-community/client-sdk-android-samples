package com.vonage.sample.channel.messaging;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.*;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;

public class ReceiveMessageActivityJava extends AppCompatActivity {

    private NexmoMessageEventListener messageListener = new NexmoMessageEventListener() {

        @Override
        public void onTextEvent(@NonNull NexmoTextEvent textEvent) {
            String userName = textEvent.getFromMember().getUser().getName();
            String text = textEvent.getText();

            Log.d("TAG", "Message received. User " + userName + " : " + text);
            Timber.d("Message received. User " + userName + " : " + text);
        }

        @Override
        public void onAttachmentEvent(@NonNull NexmoAttachmentEvent attachmentEvent) {
        }

        @Override
        public void onEventDeleted(@NonNull NexmoDeletedEvent deletedEvent) {

        }

        @Override
        public void onSeenReceipt(@NonNull NexmoSeenEvent seenEvent) {
        }

        @Override
        public void onDeliveredReceipt(@NonNull NexmoDeliveredEvent deliveredEvent) {
        }

        @Override
        public void onTypingEvent(@NonNull NexmoTypingEvent typingEvent) {
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
