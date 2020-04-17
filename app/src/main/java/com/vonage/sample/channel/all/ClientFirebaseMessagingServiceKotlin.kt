package com.vonage.sample.channel.all

import com.google.firebase.messaging.FirebaseMessagingService
import com.nexmo.client.NexmoClient
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener

class ClientFirebaseMessagingServiceKotlin : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()

        client.enablePushNotifications(token, object : NexmoRequestListener<Void> {
            override fun onSuccess(p0: Void?) {
                TODO("not implemented")
            }

            override fun onError(apiError: NexmoApiError) {
                TODO("not implemented")
            }
        })
    }
}