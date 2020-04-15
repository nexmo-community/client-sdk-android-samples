package com.vonage.sample.channel.messaging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoConversation
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import com.vonage.sample.core.utils.AttachmentUtils
import timber.log.Timber
import java.io.File

class SendImageActivityKotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()
        getConversation(client)
    }

    private fun getConversation(client: NexmoClient) {
        client.getConversation("CONVERSATION_ID", object : NexmoRequestListener<NexmoConversation> {

            override fun onSuccess(conversation: NexmoConversation?) {
                Timber.d("Conversation loaded")

                val file = AttachmentUtils.generateImageFile(this@SendImageActivityKotlin)
                conversation?.let { sendImage(it, file) }
            }

            override fun onError(apiError: NexmoApiError) {
                Timber.d("Error: Unable to load conversation ${apiError.message}")
            }
        })
    }

    private fun sendImage(conversation: NexmoConversation, imageFile: File) {

        conversation.sendAttachment(imageFile, object : NexmoRequestListener<Void> {
            override fun onSuccess(p0: Void?) {
                Timber.d("Image sent")
            }

            override fun onError(apiError: NexmoApiError) {
                Timber.d("Error: Image not sent ${apiError.message}")
            }
        })
    }
}
