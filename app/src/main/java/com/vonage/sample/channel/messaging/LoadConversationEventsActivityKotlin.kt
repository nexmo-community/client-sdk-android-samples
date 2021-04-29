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

    private fun getEventText(typingEvent: NexmoTypingEvent): String {
        val user = typingEvent.fromMember.user.name
        val typingState = if (typingEvent.state == NexmoTypingState.ON) "typing" else "not typing"
        return "$user is $typingState"
    }

    private fun getEventText(deliveredEvent: NexmoDeliveredEvent): String {
        val user = deliveredEvent.fromMember.user.name
        return "Event from $user with id ${deliveredEvent.initialEventId()} delivered at ${deliveredEvent.creationDate}"
    }

    private fun getEventText(seenEvent: NexmoSeenEvent): String {
        val user = seenEvent.fromMember.user.name
        return "$user saw event with id ${seenEvent.initialEventId()} at ${seenEvent.creationDate}"
    }

    private fun getEventText(textEvent: NexmoTextEvent): String {
        val user = textEvent.fromMember.user.name
        return "$user said: ${textEvent.text}"
    }

    private fun getEventText(memberEvent: NexmoMemberEvent): String {
        val user = memberEvent.member.user.name

        return when (memberEvent.state) {
            NexmoMemberState.JOINED -> "$user joined"
            NexmoMemberState.INVITED -> "$user invited"
            NexmoMemberState.LEFT -> "$user left"
            else -> "Error: Unknown member event state"
        }
    }
}
