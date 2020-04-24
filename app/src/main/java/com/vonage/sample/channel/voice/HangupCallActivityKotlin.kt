package com.vonage.sample.channel.voice

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoIncomingCallListener
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener

class HangupCallActivityKotlin : AppCompatActivity() {

    private val incomingCallListener = NexmoIncomingCallListener {
        Log.d("TAG", "Incoming call $it")

        it.hangup(hangupCallListener)
    }

    private val hangupCallListener = object : NexmoRequestListener<NexmoCall> {
        override fun onSuccess(nexmoCall: NexmoCall?) {
            Log.d("TAG", "Call hangup: $nexmoCall")
        }

        override fun onError(apiError: NexmoApiError) {
            Log.d("TAG", "Error: Unable to hangup call ${apiError.message}")
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