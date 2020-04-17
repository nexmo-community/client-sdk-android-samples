package com.vonage.sample.channel.all

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoClient

class ConfigureDataCenterActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val nexmoClient = NexmoClient.Builder()
            .restEnvironmentHost("https://api-eu-1.nexmo.com")
            .environmentHost("https://ws-eu-1.nexmo.com")
            .imageProcessingServiceUrl("https://api-eu-1.nexmo.com/v1/image")
            .build(this)
    }
}