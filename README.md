[![CircleCI](https://img.shields.io/maven-central/v/com.nexmo.android/client-sdk)](https://repo.maven.apache.org/maven2/com/nexmo/android/client-sdk/)
# client-sdk-android-samples
Various samples of Nexmo Android Client-SDK.

## Client Initialization

Best place to initialize client is custom android [Application](https://developer.android.com/reference/android/app/Application) class eg. [BaseApplication.kt](app/src/main/java/com/vonage/sample/core/BaseApplication.kt).

Client parameters can be configured during initialization:
- Basic client initialization ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/BasicConfigurationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/BasicConfigurationActivityJava.java))
- Configure logging level ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/SetLogLevelActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/SetLogLevelActivityJava.java))
- Configure data center ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureDataCenterActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureDataCenterActivityJava.java))
- Configure server url ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureIceServerUrlActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureIceServerUrlActivityJava.java))

## General

- Login user ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/LoginUserActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/LoginUserActivityJava.java))
- Listen for client connection changes ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/ConnectionStateListenerActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/ConnectionStateListenerActivityJava.java))
- Check if is connected ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/IsConnectedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/IsConnectedActivityJava.java))
- Configure Firebase Messaging Service ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/ClientFirebaseMessagingServiceKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/ClientFirebaseMessagingServiceJava.java))

## Channels

Android-Client SDK supports [Messaging](https://developer.nexmo.com/client-sdk/in-app-messaging/overview) and [Voice](https://developer.nexmo.com/client-sdk/in-app-voice/overview) few communication channels.

### Messaging

Check the developer portal [documentation](https://developer.nexmo.com/client-sdk/in-app-messaging/overview),
check the [code reference](https://developer.nexmo.com/client-sdk/sdk-documentation/android) or review below examples:

### Voice
Check the developer portal [documentation](https://developer.nexmo.com/client-sdk/in-app-voice/overview),
check the [code reference](https://developer.nexmo.com/sdk/stitch/android/) or review below examples: