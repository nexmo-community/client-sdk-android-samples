package com.vonage.sample.channel.messaging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class LeaveConversationActivityKotlin : AppCompatActivity() {

    private val conversationListener = object : NexmoRequestListener<NexmoConversation> {
        override fun onSuccess(conversation: NexmoConversation?) {
            conversation?.allMembers?.firstOrNull()?.let {
                conversation.kick(it, conversationKickListener)
            }
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to load conversation ${apiError.message}")
        }
    }

    private val conversationKickListener = object : NexmoRequestListener<Any> {
        override fun onSuccess(p0: Any?) {
            Timber.d("User kick success")
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to kick user ${apiError.message}")
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