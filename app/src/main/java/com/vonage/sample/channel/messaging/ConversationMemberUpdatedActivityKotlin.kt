package com.vonage.sample.channel.messaging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.NexmoConversationListener
import com.nexmo.client.NexmoMember
import com.nexmo.client.NexmoMemberUpdatedType
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoConnectionListener
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class ConversationMemberUpdatedActivityKotlin : AppCompatActivity() {

    private val getConversationListener = object : NexmoRequestListener<NexmoConversation> {
        override fun onSuccess(conversation: NexmoConversation?) {
            conversation?.addNexmoConversationListener(conversationListener)
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to load conversation ${apiError.message}")
        }
    }

    private val conversationListener = object: NexmoConversationListener {
        override fun conversationExpired() {}

        override fun onMemberUpdated(nexmoMember: NexmoMember, nexmoMemberUpdatedType: NexmoMemberUpdatedType?) {
            Timber.d("Member ${nexmoMember.user.name} updated")
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
}