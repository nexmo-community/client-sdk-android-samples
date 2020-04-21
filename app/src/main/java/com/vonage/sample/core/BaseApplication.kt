package com.vonage.sample.core

import android.app.Application
import com.nexmo.client.NexmoClient
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Init timber
        Timber.plant(Timber.DebugTree())

        // Init the NexmoClient. You can retrieve NexmoClient instance latter by using NexmoClient.get()
        NexmoClient.Builder().build(this)
    }
}