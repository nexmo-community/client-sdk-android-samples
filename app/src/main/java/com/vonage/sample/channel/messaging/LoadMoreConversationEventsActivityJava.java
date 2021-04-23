package com.vonage.sample.channel.messaging;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoConversation;
import com.nexmo.client.NexmoEventsPage;
import com.nexmo.client.NexmoPageOrder;
import com.nexmo.client.request_listener.NexmoApiError;
import com.nexmo.client.request_listener.NexmoRequestListener;
import timber.log.Timber;

public class LoadMoreConversationEventsActivityJava extends AppCompatActivity {

    private NexmoEventsPage eventsPage;
    private NexmoRequestListener<NexmoEventsPage> conversationEventsListener = new NexmoRequestListener<NexmoEventsPage>() {
        @Override
        public void onSuccess(@Nullable NexmoEventsPage eventsPage) {
            LoadMoreConversationEventsActivityJava.this.eventsPage = eventsPage;
        }

        @Override
        public void onError(@NonNull NexmoApiError apiError) {
            Timber.d("Error: Unable to load conversation events %s", apiError.getMessage());
        }
    };
    private NexmoRequestListener<NexmoConversation> getConversationListener = new NexmoRequestListener<NexmoConversation>() {
        @Override
        public void onSuccess(@Nullable NexmoConversation conversation) {
            conversation.getEvents(100, NexmoPageOrder.NexmoMPageOrderAsc, null, conversationEventsListener);
        }

        @Override
        public void onError(@NonNull NexmoApiError apiError) {
            Timber.d("Error: Unable to load conversation %s", apiError.getMessage());
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        // No need for client initialization here. Client initialization is already done in BaseApplication class.
        // new NexmoClient.Builder().build(this);
        NexmoClient client = NexmoClient.get();
        client.login("JWT token");
        client.getConversation("CONVERSATION_ID", getConversationListener);
    }

    private void loadPrevEventsPage() {
        // Bug isPrevPageExist is not public https://nexmoinc.atlassian.net/browse/CSA-1234
//        if(eventsPage.isPrevPageExist()) {
//            eventsPage.getPrev(conversationEventsListener);
//        }
    }

    private void loadNextEventsPage() {
        if (eventsPage.isNextPageExist()) {
            eventsPage.getNext(conversationEventsListener);
        }
    }
}
