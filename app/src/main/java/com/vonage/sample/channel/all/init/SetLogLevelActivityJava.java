package com.vonage.sample.channel.all.init;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoClient;

import static com.nexmo.utils.logger.ILogger.eLogLevel;

public class SetLogLevelActivityJava extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        NexmoClient client = new NexmoClient.Builder()
                .logLevel(eLogLevel.SENSITIVE)
                .build(this);
    }
}
