package com.vonage.sample.channel.messaging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.NexmoMemberEvent
import com.nexmo.client.NexmoMemberEventListener
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class AcceptUserInvitationAndJoinConversationActivityKotlin : AppCompatActivity() {

    private var conversation: NexmoConversation? = null

    private val conversationListener = object : NexmoRequestListener<NexmoConversation> {
        override fun onSuccess(conversation: NexmoConversation?) {
            Timber.d("Conversation loaded")

            conversation?.addMemberEventListener(memberEventListener)
            this@AcceptUserInvitationAndJoinConversationActivityKotlin.conversation = conversation
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to load conversation ${apiError.message}")
        }
    }

    private val memberEventListener = object : NexmoMemberEventListener {
        override fun onMemberInvited(memberEvent: NexmoMemberEvent) {
            // Join user to the conversation (accept the invitation)
            conversation?.join(memberEvent.member.user.name, joinConversationListener)
        }

        override fun onMemberRemoved(memberEvent: NexmoMemberEvent) {}

        override fun onMemberAdded(memberEvent: NexmoMemberEvent) {}
    }

    private val joinConversationListener = object : NexmoRequestListener<String> {
        override fun onSuccess(memberId: String?) {
            Timber.d("Member joined the conversation $memberId")
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to join member to the conversation $apiError")
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