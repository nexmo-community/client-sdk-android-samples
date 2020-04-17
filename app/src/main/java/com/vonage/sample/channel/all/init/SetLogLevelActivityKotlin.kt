package com.vonage.sample.channel.all.init

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient
import com.nexmo.utils.logger.ILogger.eLogLevel

class SetLogLevelActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val nexmoClient = NexmoClient.Builder()
            .logLevel(eLogLevel.SENSITIVE)
            .build(this)
    }
}