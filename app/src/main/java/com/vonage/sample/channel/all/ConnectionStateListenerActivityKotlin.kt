package com.vonage.sample.channel.all

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import timber.log.Timber

class ConnectionStateListenerActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()

        client.setConnectionListener { connectionStatus, connectionStatusReason ->
            Timber.d("Connection status changed: $connectionStatus $connectionStatusReason")
        }
    }
}