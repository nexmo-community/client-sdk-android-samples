# Nexmo Android Client SDK Samples

Repository contains Base [configuration](configuration.md) and various samples of using Nexmo [Android Client-SDK](https://developer.nexmo.com/client-sdk/overview).

# Client configuration

Client allows to configure multiple settings during initialization:
- Basic client initialization ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/BasicConfigurationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/BasicConfigurationActivityJava.java))
- Configure logging level ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/SetLogLevelActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/SetLogLevelActivityJava.java))
- Configure data center ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureDataCenterActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureDataCenterActivityJava.java))
- Configure server URL ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureIceServerUrlActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureIceServerUrlActivityJava.java))

# General tasks

- Login user ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/LoginUserActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/LoginUserActivityJava.java))
- Listen for client connection status changes ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/ConnectionStateListenerActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/ConnectionStateListenerActivityJava.java))
- Check if is connected ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/IsConnectedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/IsConnectedActivityJava.java))
- Configure Firebase Messaging Service ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/ClientFirebaseMessagingServiceKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/ClientFirebaseMessagingServiceJava.java))

# Channels

Android-Client SDK supports [Messaging](https://developer.nexmo.com/client-sdk/in-app-messaging/overview) and [Voice](https://developer.nexmo.com/client-sdk/in-app-voice/overview) communication channels.

## Messagings

### Examples

- Load conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationActivityJava.java))
- Load conversation events([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationEventsActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationEventsActivityJava.java))
- Send message ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/SendMessageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/SendMessageActivityJava.java))
- Receive message ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveMessageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveMessageActivityJava.java))
- Typing indicator ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/TypingIndicatorActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/TypingIndicatorActivityJava.java))
- Invite user ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/InviteUserActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/InviteUserActivityJava.java))
- Join conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/JoinConversationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/JoinConversationActivityJava.java))
- Leave conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/LeaveConversationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/LeaveConversationActivityJava.java))
- Accept user invitation and join the conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/AcceptUserInvitationAndJoinConversationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/AcceptUserInvitationAndJoinConversationActivityJava.java))
- Member added to the conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/MemberAddedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/MemberAddedActivityJava.java))
- Member invited to the conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/MemberInvitedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/MemberInvitedActivityJava.java))
- Member removed from the conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/MemberRemovedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/MemberRemovedActivityJava.java))
- Send image attachment ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/SendImageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/SendImageActivityJava.java))
- Receive image attachment ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveImageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveImageActivityJava.java))
- Send custom event ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/SendCustomEventActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/SendCustomEventActivityJava.java))
- Receive custom event ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveCustomEventActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveCustomEventActivityJava.java))
- The event seen by another user ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/SeenReceiptActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/SeenReceiptActivityJava.java))

### More

- Documentation at [Nexmo portal documentation](https://developer.nexmo.com/client-sdk/in-app-messaging/overview)
- Main interaction class: [NexmoCall](https://developer.nexmo.com/sdk/stitch/android/com/nexmo/client/NexmoConversation.html)
- Full [code reference](https://developer.nexmo.com/client-sdk/sdk-documentation/android)

## Voice

The capabilities of `in-app call` are limited, because they doesn't utilize [Nexmo Voice API](https://developer.nexmo.com/voice/voice-api/overview). This method is recommended mostly for onboarding. Later, it is recommended to use a `server managed call`.

### Examples

- Start in-app call - ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/StartInAppCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/StartInAppCallActivityJava.java))
- Start server managed call ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/StartServerManagedCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/StartServerManagedCallActivityJava.java))
- Receive call events ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/ReceiveCallEventsActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/ReceiveCallEventsActivityJava.java))
- Answer incoming call ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/AnswerIncomingCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/AnswerIncomingCallActivityJava.java))
- Hang up call ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/HangupCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/HangupCallActivityJava.java))
- Mute call ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/MuteCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/MuteCallActivityJava.java))
- Unmute call ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/UnmuteCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/UnmuteCallActivityJava.java))
- Mute call member ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/MuteCallMemberActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/MuteCallMemberActivityJava.java))
- Unmute call member ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/UnmuteCallMemberActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/UnmuteCallMemberActivityJava.java))
- Mute call my member ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/MuteCallMyMemberActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/MuteCallMyMemberActivityJava.java))
- Unmute call my member ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/UnmuteCallMyMemberActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/UnmuteCallMyMemberActivityJava.java))

### More

- Documentation at [Nexmo portal documentation](https://developer.nexmo.com/client-sdk/in-app-voice/overview)
- Main interaction class: [NexmoCall](https://developer.nexmo.com/sdk/stitch/android/com/nexmo/client/NexmoCall.html)
- Full [code reference](https://developer.nexmo.com/client-sdk/sdk-documentation/android)