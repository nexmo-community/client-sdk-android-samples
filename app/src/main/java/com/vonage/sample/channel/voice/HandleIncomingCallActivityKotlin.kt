package com.vonage.sample.channel.voice

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoIncomingCallListener

class HandleIncomingCallActivityKotlin : AppCompatActivity() {

    private val incomingCallListener = NexmoIncomingCallListener {
        Log.d("TAG", "Incoming call $it")
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