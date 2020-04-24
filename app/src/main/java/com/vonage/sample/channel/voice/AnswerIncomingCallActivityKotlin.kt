package com.vonage.sample.channel.voice

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoIncomingCallListener
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class AnswerIncomingCallActivityKotlin : AppCompatActivity() {

    private val incomingCallListener = NexmoIncomingCallListener {
        Timber.d("Incoming call $it")

        it.answer(answerCallListener)
    }

    private val answerCallListener = object : NexmoRequestListener<NexmoCall> {
        override fun onSuccess(call: NexmoCall?) {
            Timber.d("Call answered: $call")
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to answer incoming call ${apiError.message}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()
        client.login("JWT token")
        client.addIncomingCallListener(incomingCallListener)
    }
}