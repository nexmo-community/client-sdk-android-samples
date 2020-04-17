package com.vonage.sample.channel.all;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.nexmo.client.NexmoCall;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoEvent;
import com.nexmo.client.NexmoPushEventListener;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;

public class ClientFirebaseMessagingServiceJava extends FirebaseMessagingService {

    // No need for client initialization here. Client initialization is already done in BaseApplication class.
    // new NexmoClient.Builder().build(this);
    private NexmoClient client = NexmoClient.get();

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        client.enablePushNotifications(token, new NexmoRequestListener<Void>() {
            @Override
            public void onSuccess(@Nullable Void p0) {}

            @Override
            public void onError(@NonNull NexmoApiError nexmoApiError) {}
        });
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // determine if the message is sent from Nexmo server
        if (NexmoClient.isNexmoPushNotification(remoteMessage.getData())) {
            client.processNexmoPush(remoteMessage.getData(), new NexmoPushEventListener() {
                @Override
                public void onIncomingCall(NexmoCall call) {
                    Timber.d("FirebaseMessage:onIncomingCall() with: " + call);
                }

                @Override
                public void onNewEvent(NexmoEvent event) {
                    Timber.d("FirebaseMessage:onNewEvent() with: " + event);
                }

                @Override
                public void onError(NexmoApiError apiError) {
                    Timber.d("FirebaseMessage:onError() with: " + apiError);
                }
            });
        }
    }
}
