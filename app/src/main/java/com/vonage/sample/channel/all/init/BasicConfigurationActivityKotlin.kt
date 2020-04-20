package com.vonage.sample.channel.all.init

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient

class BasicConfigurationActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val nexmoClient = NexmoClient.Builder().build(this)
        // Now client instance can be retrieved by using NexmoClient.get()
    }
}