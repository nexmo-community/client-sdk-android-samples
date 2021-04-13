package com.vonage.sample.channel.voice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoCall;
import com.nexmo.client.NexmoCallEventListener;
import com.nexmo.client.NexmoCallHandler;
import com.nexmo.client.NexmoCallMember;
import com.nexmo.client.NexmoCallMemberStatus;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoMediaActionState;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;


public class DisableEarmuffActivityJava extends AppCompatActivity {

    private NexmoCallEventListener callEventListener = new NexmoCallEventListener() {
        @Override
        public void onEarmuffChanged(NexmoMediaActionState earmuffState, NexmoCallMember callMember) {
            Timber.d("onEarmuffChanged(): earmuffState: " + earmuffState + ", callMember: " + callMember);
        }

        @Override
        public void onMemberStatusUpdated(NexmoCallMemberStatus $memberStatus, NexmoCallMember callMember) {}

        @Override
        public void onMuteChanged(NexmoMediaActionState muteState, NexmoCallMember callMember) {}

        @Override
        public void onDTMF(String digit, NexmoCallMember callMember) {}
    };

    private NexmoRequestListener<NexmoCallMember> earmuffListener = new NexmoRequestListener<NexmoCallMember>() {
        @Override
        public void onSuccess(NexmoCallMember callMember) {
            Timber.d("Member earmuff " + callMember);
        }

        @Override
        public void onError(NexmoApiError apiError) {
            Timber.d("Error: Earmuff member " + apiError.getMessage());
        }
    };

    private NexmoRequestListener<NexmoCall> callListener = new NexmoRequestListener<NexmoCall>() {
        @Override
        public void onSuccess(@Nullable NexmoCall call) {
            Timber.d("Call started: " + call.toString());

            call.addCallEventListener(callEventListener);

            // Earmuff member
            NexmoCallMember callMember = call.getCallMembers().iterator().next();
            callMember.earmuff(false, earmuffListener);

            // Earmuff my member
            call.getMyCallMember().earmuff(false, earmuffListener);
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

