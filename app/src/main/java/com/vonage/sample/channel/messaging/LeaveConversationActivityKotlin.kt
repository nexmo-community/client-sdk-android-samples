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
                val member = conversation?.allMembers?.firstOrNull()

                member?.let {
                    conversation.kick(it, object : NexmoRequestListener<Any> {
                        override fun onSuccess(p0: Any?) {
                            Timber.d("User kick success")
                        }

                        override fun onError(apiError: NexmoApiError) {
                            Timber.d("Error: Unable kick user ${apiError.message}")
                        }
                    })
                }
            }

            override fun onError(apiError: NexmoApiError) {
                Timber.d("Error: Unable to load conversation ${apiError.message}")
            }
        })
    }
}