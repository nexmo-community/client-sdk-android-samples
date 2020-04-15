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
import com.vonage.sample.core.utils.AttachmentUtils;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

import java.io.File;

public class SendImageActivityJava extends AppCompatActivity {

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

                File file = AttachmentUtils.generateImageFile(SendImageActivityJava.this);
                sendImage(conversation, file);
            }

            @Override
            public void onError(@NonNull NexmoApiError apiError) {
                Timber.d("Error: Unable to load conversation %s", apiError.getMessage());
            }
        });
    }

    private void sendImage(@NonNull NexmoConversation conversation, File imageFile) {
        conversation.sendAttachment(imageFile, new NexmoRequestListener<Void>() {
            public void onSuccess(@Nullable Void p0) {
                Timber.d("Image sent");
            }

            public void onError(@NotNull NexmoApiError apiError) {
                Timber.d("Error: Image not sent %s", apiError.getMessage());
            }
        });
    }
}
