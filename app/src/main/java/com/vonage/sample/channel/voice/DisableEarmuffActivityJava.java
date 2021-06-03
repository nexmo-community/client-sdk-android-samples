package com.vonage.sample.channel.voice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.*;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;


public class DisableEarmuffActivityJava extends AppCompatActivity {

    private NexmoCallEventListener callEventListener = new NexmoCallEventListener() {
        @Override
        public void onEarmuffChanged(NexmoMediaActionState earmuffState, NexmoMember nexmoMember) {
            Timber.d("onEarmuffChanged(): earmuffState: " + earmuffState + ", nexmoMember: " + nexmoMember);
        }

        @Override
        public void onMemberStatusUpdated(NexmoCallMemberStatus $memberStatus, NexmoMember nexmoMember) {}

        @Override
        public void onMuteChanged(NexmoMediaActionState muteState, NexmoMember nexmoMember) {}

        @Override
        public void onDTMF(String digit, NexmoMember nexmoMember) {}
    };

    private NexmoRequestListener<Void> earmuffListener = new NexmoRequestListener<Void>() {
        @Override
        public void onError(NexmoApiError apiError) {
            Timber.d("Error: Earmuff member " + apiError.getMessage());
        }

        @Override
        public void onSuccess(@Nullable Void result) {
            Timber.d("Member earmuff ");
        }
    };

    private NexmoRequestListener<NexmoCall> callListener = new NexmoRequestListener<NexmoCall>() {
        @Override
        public void onSuccess(@Nullable NexmoCall call) {
            Timber.d("Call started: " + call.toString());

            call.addCallEventListener(callEventListener);
            NexmoMember nexmoMember = call.getAllMembers().get(0);

            // Disable member earmuff
            nexmoMember.disableEarmuff(earmuffListener);
        }

        @Override
        public void onError(@NonNull NexmoApiError apiError) {
            Timber.d("Error: Unable to start a call " + apiError.getMessage());
        }
    };

    @SuppressLint("MissingPermission")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // new NexmoClient.Builder().build(this);
        NexmoClient client = NexmoClient.get();
        client.login("JWT token");

        client.call("123456", NexmoCallHandler.SERVER, callListener);
    }
}

