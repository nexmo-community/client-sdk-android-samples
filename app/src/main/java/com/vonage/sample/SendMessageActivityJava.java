package com.vonage.sample;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoConversation;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class SendMessageActivityJava extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        NexmoClient client = NexmoClient.get();
        client.login("JWT token");
        getConversation(client);

    }

    private void getConversation(NexmoClient client) {
        client.getConversation("CONVERSATION_ID", new NexmoRequestListener<NexmoConversation>() {

            @Override
            public void onSuccess(@Nullable NexmoConversation conversation) {
                Timber.d("Conversation loaded");
                sendMessage(conversation, "Hello");
            }

            @Override
            public void onError(@NonNull NexmoApiError apiError) {
                Timber.d("Error: Unable to load conversation %s", apiError.getMessage());
            }
        });
    }

    private void sendMessage(NexmoConversation conversation, String message) {
        conversation.sendText(message, new NexmoRequestListener<Void>() {
            public void onSuccess(@Nullable Void p0) {
                Timber.d("Message has been sent");
            }

            public void onError(@NotNull NexmoApiError apiError) {
                Timber.d("Error: Message not sent  %s", apiError.getMessage());
            }
        });
    }
}
