package com.vonage.sample.channel.voice

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nexmo.client.NexmoCall
import com.nexmo.client.NexmoCallEventListener
import com.nexmo.client.NexmoCallHandler
import com.nexmo.client.NexmoCallMemberStatus
import com.nexmo.client.NexmoClient
import com.nexmo.client.NexmoMediaActionState
import com.nexmo.client.NexmoMember
import com.nexmo.client.request_listener.NexmoApiError
import com.nexmo.client.request_listener.NexmoRequestListener
import timber.log.Timber

class MuteActivityKotlin : AppCompatActivity() {

    private val callListener = object : NexmoRequestListener<NexmoCall> {
        override fun onSuccess(call: NexmoCall?) {
            Timber.d("Call started: ${call.toString()}")

            call?.addCallEventListener(callEventListener)
            val nexmoMember = call?.allMembers?.firstOrNull()

            // Mute member
            nexmoMember?.enableMute(muteListener)

            // Mute whole call
            call?.mute(true)
        }

        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Unable to start a call ${apiError.message}")
        }
    }

    private val callEventListener = object : NexmoCallEventListener {
        override fun onMuteChanged(muteState: NexmoMediaActionState?, nexmoMember: NexmoMember?) {
            Timber.d("NexmoMediaActionState(): muteState: $muteState, nexmoMember: $nexmoMember")
        }

        override fun onDTMF(digit: String?, nexmoMember: NexmoMember?) {}

        override fun onMemberStatusUpdated(memberStatus: NexmoCallMemberStatus?, nexmoMember: NexmoMember?) {}

        override fun onEarmuffChanged(earmuffState: NexmoMediaActionState?, nexmoMember: NexmoMember?) {}
    }

    private val muteListener = object : NexmoRequestListener<Void> {
        override fun onError(apiError: NexmoApiError) {
            Timber.d("Error: Mute member ${apiError.message}")
        }

        override fun onSuccess(result: Void?) {
            Timber.d("Member muted")
        }
    }

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // NexmoClient.Builder().build(this)
        val client = NexmoClient.get()
        client.login("JWT token")

        client.call("123456", NexmoCallHandler.SERVER, callListener)
    }
}