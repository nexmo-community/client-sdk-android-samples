package com.vonage.sample.channel.voice;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoCall;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoIncomingCallListener;
import timber.log.Timber;

public class ReceiveIncomingCallActivityJava extends AppCompatActivity {

    private NexmoIncomingCallListener incomingCallListener = new NexmoIncomingCallListener() {
        @Override
        public void onIncomingCall(NexmoCall call) {
            Timber.d("Incoming call " + call);
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
