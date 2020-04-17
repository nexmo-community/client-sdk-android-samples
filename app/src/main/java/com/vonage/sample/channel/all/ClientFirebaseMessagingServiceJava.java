package com.vonage.sample.channel.all;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;

public class ClientFirebaseMessagingServiceJava extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // new NexmoClient.Builder().build(this);
        NexmoClient client = NexmoClient.get();

        client.enablePushNotifications(token, new NexmoRequestListener<Void>() {
            @Override
            public void onSuccess(@Nullable Void p0) {}

            @Override
            public void onError(@NonNull NexmoApiError nexmoApiError) {}
        });
    }
}
