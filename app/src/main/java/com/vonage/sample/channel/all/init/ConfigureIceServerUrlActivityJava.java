package com.vonage.sample.channel.all.init;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoClient;

public class ConfigureIceServerUrlActivityJava extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        NexmoClient client = new NexmoClient.Builder()
                .iceServerUrls(new String[]{"STUN1_URL"})
                .build(this);
    }
}
