package com.vonage.sample.channel.all

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoEvent
import com.nexmo.client.NexmoPushEventListener
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class ClientFirebaseMessagingServiceKotlin : FirebaseMessagingService() {

    // No need for client initialization here. Client initialization is already done in BaseApplication class.
    // NexmoClient.Builder().build(this)
    private val client = NexmoClient.get()

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        client.enablePushNotifications(token, object : NexmoRequestListener<Void> {
            override fun onSuccess(p0: Void?) {
                TODO("not implemented")
            }

            override fun onError(apiError: NexmoApiError) {
                TODO("not implemented")
            }
        })
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // determine if the message is sent from Nexmo server
        if (NexmoClient.isNexmoPushNotification(remoteMessage.data)) {
            client.processNexmoPush(remoteMessage.data, object : NexmoPushEventListener {
                override fun onIncomingCall(call: NexmoCall?) {
                    Timber.d("FirebaseMessage:onIncomingCall() with: $call")
                }

                override fun onNewEvent(event: NexmoEvent?) {
                    Timber.d("FirebaseMessage:onNewEvent() with: $event")
                }

                override fun onError(apiError: NexmoApiError?) {
                    Timber.d("FirebaseMessage:onError() with: $apiError")
                }
            })
        }
    }
}