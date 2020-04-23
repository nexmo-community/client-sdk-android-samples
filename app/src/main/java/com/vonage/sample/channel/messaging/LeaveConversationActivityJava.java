package com.vonage.sample.channel.messaging;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoConversation;
import com.nexmo.client.NexmoMember;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;

public class LeaveConversationActivityJava extends AppCompatActivity {

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

                if (conversation.getAllMembers().size() > 0) {
                    NexmoMember member = conversation.getAllMembers().iterator().next();
                    conversation.kick(member, new NexmoRequestListener<Void>() {
                        @Override
                        public void onSuccess(@Nullable Void aVoid) {
                            Timber.d("User kick success");
                        }

                        @Override
                        public void onError(@NonNull NexmoApiError apiError) {
                            Timber.d("Error: Unable to kick user " + apiError.getMessage());
                        }
                    });
                }
            }

            @Override
            public void onError(@NonNull NexmoApiError apiError) {
                Timber.d("Error: Unable to load conversation %s", apiError.getMessage());
            }
        });
    }
}
