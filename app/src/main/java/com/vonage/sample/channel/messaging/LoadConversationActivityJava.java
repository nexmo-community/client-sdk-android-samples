package com.vonage.sample.channel.messaging;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoConversation;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;

public class LoadConversationActivityJava extends AppCompatActivity {

    private NexmoRequestListener<NexmoConversation> conversationListener = new NexmoRequestListener<NexmoConversation>() {
        @Override
        public void onSuccess(@Nullable NexmoConversation conversation) {
            Timber.d("Conversation loaded");
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
        client.getConversation("CONVERSATION_ID", conversationListener);
    }
}
