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
import com.nexmo.client.NexmoMember;
import com.nexmo.client.NexmoCallMemberStatus;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoMediaActionState;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;

public class ReceiveCallEventsActivityJava extends AppCompatActivity {

    private NexmoCallEventListener callEventListener = new NexmoCallEventListener() {

        @Override
        public void onMemberStatusUpdated(NexmoCallMemberStatus $memberStatus, NexmoMember nexmoMember) {
            Timber.d("onMemberStatusUpdated(): status: " + $memberStatus + " nexmoMember: " + nexmoMember);
        }

        @Override
        public void onMuteChanged(NexmoMediaActionState muteState, NexmoMember nexmoMember) {
            Timber.d("NexmoMediaActionState(): muteState: " + muteState + ", nexmoMember: " + nexmoMember);
        }

        @Override
        public void onEarmuffChanged(NexmoMediaActionState earmuffState, NexmoMember nexmoMember) {
            Timber.d("onEarmuffChanged(): earmuffState: " + earmuffState + ", nexmoMember: " + nexmoMember);
        }

        @Override
        public void onDTMF(String digit, NexmoMember nexmoMember) {
            Timber.d("onDTMF(): digit:" + digit + ", nexmoMember: " + nexmoMember);
        }
    };

    private NexmoRequestListener<NexmoCall> callListener = new NexmoRequestListener<NexmoCall>() {
        @Override
        public void onSuccess(@Nullable NexmoCall nexmoCall) {
            Timber.d("Call started: " + nexmoCall.toString());

            nexmoCall.addCallEventListener(callEventListener);
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

        client.call("123456", NexmoCallHandler.IN_APP, callListener);
    }
}
