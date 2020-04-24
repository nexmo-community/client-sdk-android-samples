package com.vonage.sample.channel.voice

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoCallEventListener
import com.nexmo.client.NexmoCallHandler
import com.nexmo.client.NexmoCallMember
import com.nexmo.client.NexmoCallMemberStatus
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoMediaActionState
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class ReceiveCallEventsActivityKotlin : AppCompatActivity() {

    private val callListener = object : NexmoRequestListener<NexmoCall> {
        override fun onSuccess(call: NexmoCall?) {
            Timber.d("Call started: " + call.toString())

            call?.addCallEventListener(callEventListener)
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to start a call ${apiError.message}")
        }
    }

    private val callEventListener = object : NexmoCallEventListener {
        override fun onDTMF(digit: String?, callMember: NexmoCallMember?) {
            Timber.d("v: digit: $digit, callMember: $callMember")
        }

        override fun onMemberStatusUpdated(memberStatus: NexmoCallMemberStatus?, callMember: NexmoCallMember?) {
            Timber.d("onMemberStatusUpdated: status: $memberStatus, callMember: $callMember")
        }

        override fun onMuteChanged(muteState: NexmoMediaActionState?, callMember: NexmoCallMember?) {
            Timber.d("onMuteChanged: muteState: $muteState, callMember: $callMember")
        }

        override fun onEarmuffChanged(earmuffState: NexmoMediaActionState?, callMember: NexmoCallMember?) {
            Timber.d("onEarmuffChanged: earmuffState: $earmuffState, callMember: $callMember")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()
        client.login("JWT token")

        client.call("123456", NexmoCallHandler.IN_APP, callListener)
    }
}