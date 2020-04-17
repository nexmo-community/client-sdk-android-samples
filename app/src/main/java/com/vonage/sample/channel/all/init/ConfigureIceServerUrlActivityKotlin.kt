package com.vonage.sample.channel.all.init

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient

class ConfigureIceServerUrlActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val nexmoClient = NexmoClient.Builder()
            .iceServerUrls(arrayOf("STUN1_URL"))
            .build(this)
    }
}