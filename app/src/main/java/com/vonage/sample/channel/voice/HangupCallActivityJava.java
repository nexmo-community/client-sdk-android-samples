package com.vonage.sample.channel.voice;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoCall;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoIncomingCallListener;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;

public class HangupCallActivityJava extends AppCompatActivity {

    private NexmoRequestListener<NexmoCall> hangupCallListener = new NexmoRequestListener<NexmoCall>() {
        @Override
        public void onSuccess(@Nullable NexmoCall nexmoCall) {
            Log.d("TAG", "Call hangup: " + nexmoCall);
        }

        @Override
        public void onError(@NonNull NexmoApiError apiError) {
            Log.d("TAG", "Error: Unable to hangup call " + apiError.getMessage());
        }
    };
    private NexmoIncomingCallListener incomingCallListener = new NexmoIncomingCallListener() {
        @Override
        public void onIncomingCall(NexmoCall call) {
            Log.d("TAG", "Incoming call " + call);

            call.hangup(hangupCallListener);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // new NexmoClient.Builder().build(this);
        NexmoClient client = NexmoClient.get();
        client.login("JWT token");
        client.addIncomingCallListener(incomingCallListener);
    }
}
