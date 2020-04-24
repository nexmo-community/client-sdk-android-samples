package com.vonage.sample.channel.voice

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoCallHandler
import com.nexmo.client.NexmoCallMember
import com.nexmo.client.NexmoClient
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class UnmuteCallActivityKotlin : AppCompatActivity() {

    private val callListener = object : NexmoRequestListener<NexmoCall> {
        override fun onSuccess(call: NexmoCall?) {
            Timber.d("Call started: ${call.toString()}")

            // Mute member
            call?.callMembers?.firstOrNull()?.mute(false, muteListener)

            // Mute my member
            call?.myCallMember?.mute(false, muteListener)

            // Mute whole call
            call?.mute(false)
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to start a call ${apiError.message}")
        }
    }

    private val muteListener = object : NexmoRequestListener<NexmoCallMember> {
        override fun onSuccess(callMember: NexmoCallMember?) {
            Timber.d("Member unmuted $callMember")
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unute member ${apiError.message}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()
        client.login("JWT token")
        client.call("123456", NexmoCallHandler.SERVER, callListener)
    }
}