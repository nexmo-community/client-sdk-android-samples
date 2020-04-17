package com.vonage.sample.channel.all.init;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoClient;

public class ConfigureDataCenterActivityJava extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        NexmoClient nexmoClient = new NexmoClient.Builder()
                .restEnvironmentHost("https://api-eu-1.nexmo.com")
                .environmentHost("https://ws-eu-1.nexmo.com")
                .imageProcessingServiceUrl("https://api-eu-1.nexmo.com/v1/image")
                .build(this);
    }
}
