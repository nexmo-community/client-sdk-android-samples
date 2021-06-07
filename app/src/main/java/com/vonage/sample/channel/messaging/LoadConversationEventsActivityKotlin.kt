package com.vonage.sample.channel.messaging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.NexmoDeliveredEvent
import com.nexmo.client.NexmoEvent
import com.nexmo.client.NexmoEventsPage
import com.nexmo.client.NexmoMemberEvent
import com.nexmo.client.NexmoMemberState
import com.nexmo.client.NexmoPageOrder
import com.nexmo.client.NexmoSeenEvent
import com.nexmo.client.NexmoTextEvent
import com.nexmo.client.NexmoTypingEvent
import com.nexmo.client.NexmoTypingState
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class LoadConversationEventsActivityKotlin : AppCompatActivity() {

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
            eventsPage?.data?.let {
                processEvents(it.toList())
            }
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

    private fun processEvents(events: List<NexmoEvent>) {
        events.forEach {
            val message = when (it) {
                is NexmoMemberEvent -> getEventText(it)
                is NexmoTextEvent -> getEventText(it)
                is NexmoSeenEvent -> getEventText(it)
                is NexmoDeliveredEvent -> getEventText(it)
                is NexmoTypingEvent -> getEventText(it)
                else -> "Unsupported event ${it.eventType}"
            }

            Timber.d(message)
        }
    }

    private fun getEventText(event: NexmoTypingEvent): String {
        val typingState = if (event.state == NexmoTypingState.ON) "typing" else "not typing"
        return "${event.fromMemberId} is $typingState"
    }

    private fun getEventText(event: NexmoDeliveredEvent): String {
        val userName = event.fromMemberId
        return "Event from $userName with id ${event.initialEventId()} delivered at ${event.creationDate}"
    }

    private fun getEventText(event: NexmoSeenEvent): String {
        return "${event.fromMemberId} saw event with id ${event.initialEventId()} at ${event.creationDate}"
    }

    private fun getEventText(event: NexmoTextEvent): String {
        return "${event.fromMemberId} said: ${event.text}"
    }

    private fun getEventText(event: NexmoMemberEvent): String {
        val userName = event.fromMemberId

        return when (event.state) {
            NexmoMemberState.JOINED -> "$userName joined"
            NexmoMemberState.INVITED -> "$userName invited by ${event.invitedBy}"
            NexmoMemberState.LEFT -> "$userName left"
            else -> "Error: Unknown member event state"
        }
    }
}
