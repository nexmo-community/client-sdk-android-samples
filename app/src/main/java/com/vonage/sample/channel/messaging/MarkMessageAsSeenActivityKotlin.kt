package com.vonage.sample.channel.messaging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoAttachmentEvent
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.NexmoDeletedEvent
import com.nexmo.client.NexmoDeliveredEvent
import com.nexmo.client.NexmoMessageEventListener
import com.nexmo.client.NexmoSeenEvent
import com.nexmo.client.NexmoTextEvent
import com.nexmo.client.NexmoTypingEvent
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class MarkMessageAsSeenActivityKotlin : AppCompatActivity() {

    private val messageListener = object : NexmoMessageEventListener {
        override fun onTypingEvent(typingEvent: NexmoTypingEvent) {}

        override fun onAttachmentEvent(attachmentEvent: NexmoAttachmentEvent) {}

        override fun onTextEvent(textEvent: NexmoTextEvent) {
            textEvent.markAsSeen(markAsSeemListener)
        }

        override fun onSeenReceipt(seenEvent: NexmoSeenEvent) {}

        override fun onEventDeleted(deletedEvent: NexmoDeletedEvent) {}

        override fun onDeliveredReceipt(deliveredEvent: NexmoDeliveredEvent) {}
    }

    private val markAsSeemListener = object: NexmoRequestListener<Any> {
        override fun onSuccess(p0: Any?) {
            Timber.d("Message marked as seen")
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to mark message as seen ${apiError.message}")
        }
    }

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
                conversation?.addMessageEventListener(messageListener)
            }

            override fun onError(apiError: NexmoApiError) {
                Timber.d("Error: Unable to load conversation ${apiError.message}")
            }
        })
    }
}