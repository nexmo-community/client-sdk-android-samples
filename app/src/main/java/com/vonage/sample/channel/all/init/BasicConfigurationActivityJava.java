package com.vonage.sample.channel.all.init;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoClient;

public class BasicConfigurationActivityJava extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        NexmoClient nexmoClient = new NexmoClient.Builder().build(this);
        // Now client instance can be retrieved by using NexmoClient.get()
    }
}
