package com.vonage.sample.channel.messaging;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoConversation;
import com.nexmo.client.NexmoMemberEvent;
import com.nexmo.client.NexmoMemberEventListener;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;

public class MemberAddedActivityJava extends AppCompatActivity {

    private NexmoConversation conversation;

    private NexmoMemberEventListener memberEventListener = new NexmoMemberEventListener() {
        @Override
        public void onMemberInvited(@NonNull NexmoMemberEvent memberEvent) {}

        @Override
        public void onMemberAdded(@NonNull NexmoMemberEvent memberEvent) {
            Timber.d("Member " + memberEvent.getMember().getUser().getName() + " added to the conversation");
        }

        @Override
        public void onMemberRemoved(@NonNull NexmoMemberEvent memberEvent) {}
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

                conversation.addMemberEventListener(memberEventListener);
            }

            @Override
            public void onError(@NonNull NexmoApiError apiError) {
                Timber.d("Error: Unable to load conversation %s", apiError.getMessage());
            }
        });
    }
}
