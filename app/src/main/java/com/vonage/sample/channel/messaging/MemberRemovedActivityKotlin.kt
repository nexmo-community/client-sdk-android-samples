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

class MemberRemovedActivityKotlin : AppCompatActivity() {

    private val memberEventListener = object : NexmoMemberEventListener {
        override fun onMemberInvited(memberEvent: NexmoMemberEvent) {}

        override fun onMemberAdded(memberEvent: NexmoMemberEvent) {}

        override fun onMemberRemoved(memberEvent: NexmoMemberEvent) {
            Timber.d("Member ${memberEvent.member.user.name} removed from the conversation")
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

                conversation?.addMemberEventListener(memberEventListener)
            }

            override fun onError(apiError: NexmoApiError) {
                Timber.d("Error: Unable to load conversation ${apiError.message}")
            }
        })
    }
}