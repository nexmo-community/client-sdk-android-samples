package com.vonage.sample.channel.messaging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.NexmoEventsPage
import com.nexmo.client.NexmoPageOrder
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class LoadMoreConversationEventsActivityKotlin : AppCompatActivity() {

    private var eventsPage: NexmoEventsPage? = null

    private val getConversationListener = object : NexmoRequestListener<NexmoConversation> {
        override fun onSuccess(conversation: NexmoConversation?) {
            Timber.d("Conversation loaded")

            conversation?.getEvents(
                100,
                NexmoPageOrder.NexmoMPageOrderAsc,
                null,
                conversationEventsListener
            )
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to load conversation ${apiError.message}")
        }
    }

    private val conversationEventsListener = object : NexmoRequestListener<NexmoEventsPage> {
        override fun onSuccess(eventsPage: NexmoEventsPage?) {
            this@LoadMoreConversationEventsActivityKotlin.eventsPage = eventsPage
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to load conversation events ${apiError.message}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()
        client.login("JWT token")
        client.getConversation("CONVERSATION_ID", getConversationListener)
    }

    private fun loadPrevEventsPage() {
        // Bug isPrevPageExist is not public https://nexmoinc.atlassian.net/browse/CSA-1234
//        if(eventsPage?.isPrevPageExist == true) {
//            eventsPage?.getPrev(conversationEventsListener)
//        }
    }

    private fun loadNextEventsPage() {
        if (eventsPage?.isNextPageExist == true) {
            eventsPage?.getNext(conversationEventsListener)
        }
    }
}
