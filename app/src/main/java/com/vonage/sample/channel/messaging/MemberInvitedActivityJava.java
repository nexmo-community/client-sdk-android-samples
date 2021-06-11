package com.vonage.sample.channel.messaging;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.*;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class MemberInvitedActivityJava extends AppCompatActivity {

    private NexmoConversation conversation;

    private NexmoMemberEventListener memberEventListener = new NexmoMemberEventListener() {
        @Override
        public void onMemberInvited(@NonNull @NotNull NexmoMemberEvent event, @NonNull @NotNull NexmoMemberSummary member) {
            Timber.d("Member " + member.getUser().getName()
                    + " was invited to the conversation by "
                    + event.getEmbeddedInfo().getUser().getName()
            );
        }

        @Override
        public void onMemberAdded(@NonNull @NotNull NexmoMemberEvent event, @NonNull @NotNull NexmoMemberSummary member) {

        }

        @Override
        public void onMemberRemoved(@NonNull @NotNull NexmoMemberEvent event, @NonNull @NotNull NexmoMemberSummary member) {

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

                conversation.addMemberEventListener(memberEventListener);
            }

            @Override
            public void onError(@NonNull NexmoApiError apiError) {
                Timber.d("Error: Unable to load conversation %s", apiError.getMessage());
            }
        });
    }
}
