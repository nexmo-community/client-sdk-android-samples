# Nexmo Client SDK Android Samples
Base configuration and various samples of Nexmo Android Client-SDK.

## Base configuration

### Add dependency

[![Android Nexmo Client-SDK version](https://img.shields.io/maven-central/v/com.nexmo.android/client-sdk.svg)](https://repo.maven.apache.org/maven2/com/nexmo/android/client-sdk/)

Kotlin Gradle Script:
```
implementation("com.nexmo.android:client-sdk:x.y.z")
```

Groovy:
```
implementation 'com.nexmo.android:client-sdk:x.y.z'
```

### Initialize the client

The best place to initialize the client is custom android [Application](https://developer.android.com/reference/android/app/Application) class:

BaseApplication.kt
```
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        // Init the NexmoClient. You can retrieve NexmoClient instance latter by using NexmoClient.get()
        NexmoClient.Builder().build(this)
    }
}
```

BaseApplication.java
```
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Init the NexmoClient. You can retrieve NexmoClient instance latter by using NexmoClient.get()
        new NexmoClient.Builder().build(this);
    }
}
```

Now we need to use the `BaseApplication` class by adding it in the `AndroidManifest.xml` file:
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.vonage.sample">

    <application
            android:name=".core.BaseApplication"
            ...
    </application>

</manifest>
```

## Client configuration

Client allows to configure multiple settings during initialization:
- Basic client initialization ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/BasicConfigurationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/BasicConfigurationActivityJava.java))
- Configure logging level ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/SetLogLevelActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/SetLogLevelActivityJava.java))
- Configure data center ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureDataCenterActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureDataCenterActivityJava.java))
- Configure server URL ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureIceServerUrlActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureIceServerUrlActivityJava.java))

## General tasks

- Login user ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/LoginUserActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/LoginUserActivityJava.java))
- Listen for client connection status changes ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/ConnectionStateListenerActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/ConnectionStateListenerActivityJava.java))
- Check if is connected ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/IsConnectedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/IsConnectedActivityJava.java))
- Configure Firebase Messaging Service ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/ClientFirebaseMessagingServiceKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/ClientFirebaseMessagingServiceJava.java))

## Channels

Android-Client SDK supports [Messaging](https://developer.nexmo.com/client-sdk/in-app-messaging/overview) and [Voice](https://developer.nexmo.com/client-sdk/in-app-voice/overview) communication channels.

### Messaging

Check the developer portal [documentation](https://developer.nexmo.com/client-sdk/in-app-messaging/overview),
check the [code reference](https://developer.nexmo.com/client-sdk/sdk-documentation/android) or review below examples:
- Load conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationActivityJava.java))
- Load conversation events([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationEventsActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationEventsActivityJava.java))
- Send message ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/SendMessageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/SendMessageActivityJava.java))
- Receive message ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveMessageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveMessageActivityJava.java))
- Typing indicator ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/TypingIndicatorActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/TypingIndicatorActivityJava.java))
- Invite user ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/InviteUserActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/InviteUserActivityJava.java))
- Accept user invitation to conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/AcceptUserInvitationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/AcceptUserInvitationActivityJava.java))
- Member added to the conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/MemberAddedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/MemberAddedActivityJava.java))
- Member invited to the conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/MemberInvitedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/MemberInvitedActivityJava.java))
- Member removed from the conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/MemberRemovedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/MemberRemovedActivityJava.java))
- Send image attachment ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/SendImageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/SendImageActivityJava.java))
- Receive image attachment ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveImageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveImageActivityJava.java))
- Send custom event ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/SendCustomEventActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/SendCustomEventActivityJava.java))
- Receive custom event ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveCustomEventActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveCustomEventActivityJava.java))
- The event seen by another user ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/SeenReceiptActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/SeenReceiptActivityJava.java))

### Voice
Check the developer portal [documentation](https://developer.nexmo.com/client-sdk/in-app-voice/overview),
check the [code reference](https://developer.nexmo.com/sdk/stitch/android/) or review below examples: