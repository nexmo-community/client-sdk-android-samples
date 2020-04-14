package com.vonage.sample

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class LoadConversationActivityKotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val client = NexmoClient.get()
        getConversation(client)
    }

    private fun getConversation(client: NexmoClient) {
        client.getConversation("CONVERSATION_ID", object : NexmoRequestListener<NexmoConversation> {

            override fun onSuccess(conversation: NexmoConversation?) {
                Timber.d("Conversation loaded")
            }

            override fun onError(apiError: NexmoApiError) {
                Timber.d("Error: Unable to load conversation ${apiError.message}")
            }
        })
    }
}