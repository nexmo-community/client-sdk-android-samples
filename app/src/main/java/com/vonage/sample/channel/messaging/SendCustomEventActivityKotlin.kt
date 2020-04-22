package com.vonage.sample.channel.messaging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class SendCustomEventActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()
        client.login("JWT token")
        getConversation(client)
    }

    private fun getConversation(client: NexmoClient) {
        client.getConversation("CONVERSATION_ID", object : NexmoRequestListener<NexmoConversation> {
            override fun onSuccess(conversation: NexmoConversation?) {
                Timber.d("Conversation loaded")
                conversation?.let {
                    sendCustomEvent(it, "my_custom_event", hashMapOf("key" to "data"))
                }
            }

            override fun onError(apiError: NexmoApiError) {
                Timber.d("Error: Unable to load conversation ${apiError.message}")
            }
        })
    }

    private fun sendCustomEvent(conversation: NexmoConversation, eventType: String, data: HashMap<String, Any>) {
        conversation.sendCustomEvent(eventType, data, object : NexmoRequestListener<Void> {
            override fun onSuccess(p0: Void?) {
                Timber.d("Custom event sent")
            }

            override fun onError(apiError: NexmoApiError) {
                Timber.d("Custom event error")
            }
        })
    }
}
