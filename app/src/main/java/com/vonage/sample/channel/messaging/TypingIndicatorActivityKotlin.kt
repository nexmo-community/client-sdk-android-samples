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
import com.nexmo.client.NexmoTypingEventListener
import com.nexmo.client.NexmoTypingState
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class TypingIndicatorActivityKotlin : AppCompatActivity() {

    private val typingEventListener = NexmoTypingEventListener { typingEvent ->
        val typingState = if(typingEvent?.state == NexmoTypingState.ON) "typing" else "not typing"
        Timber.d("User ${typingEvent.fromMemberId} is $typingState")
    }

    private val messageListener: NexmoMessageEventListener = object : NexmoMessageEventListener {
        override fun onTextEvent(textEvent: NexmoTextEvent) {}

        override fun onAttachmentEvent(attachmentEvent: NexmoAttachmentEvent) {}

        override fun onEventDeleted(deletedEvent: NexmoDeletedEvent) {}

        override fun onSeenReceipt(seenEvent: NexmoSeenEvent) {}

        override fun onDeliveredReceipt(deliveredEvent: NexmoDeliveredEvent) {}

        override fun onTypingEvent(typingEvent: NexmoTypingEvent) {
            val typingState = if(typingEvent.state == NexmoTypingState.ON) "typing" else "not typing"
            Timber.d("User ${typingEvent.fromMemberId} is $typingState")
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

                // To send typing notification call conversation.startTyping() or conversation.stopTyping()

                // Option 1: Listen for typing events using NexmoTypingEventListener
                conversation?.addTypingEventListener(typingEventListener)

                // or

                // Option 2: Listen for typing events using NexmoMessageEventListener
                conversation?.addMessageEventListener(messageListener)
            }

            override fun onError(apiError: NexmoApiError) {
                Timber.d("Error: Unable to load conversation ${apiError.message}")
            }
        })
    }
}