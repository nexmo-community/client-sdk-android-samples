package com.vonage.sample.channel.messaging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class JoinConversationActivityKotlin : AppCompatActivity() {

    private val conversationListener = object : NexmoRequestListener<NexmoConversation> {
        override fun onSuccess(conversation: NexmoConversation?) {
            conversation?.join("member name", joinConversationListener)
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to load conversation ${apiError.message}")
        }
    }

    private val joinConversationListener = object : NexmoRequestListener<String> {
        override fun onSuccess(string: String?) {
            Timber.d("User join success")
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable join user ${apiError.message}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()
        client.login("JWT token")
        client.getConversation("CONVERSATION_ID", conversationListener)
    }
}
