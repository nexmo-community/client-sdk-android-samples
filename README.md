# Nexmo Android Client SDK Samples

Repository contains Base [configuration](configuration.md) and various samples of using Nexmo Android Client-SDK.

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
- Accept user invitation and join the conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/AcceptUserInvitationAndJoinConversationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/AcceptUserInvitationAndJoinConversationActivityJava.java))
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