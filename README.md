# Android Client SDK Samples

Repository contains Base [configuration](configuration.md) and provides some examples for you to better understand the
features of the [Android Client SDK](https://developer.nexmo.com/client-sdk/overview). The sample applications are
meant to be used with the latest version of the Android Client SDK. Feel free to copy and modify the source code herein
for your own projects. Please consider sharing your modifications with us, especially if they might benefit other
developers using the OpenTok Android SDK.

# Client configuration

Client allows to configure multiple settings during initialization:
- Basic client initialization ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/BasicConfigurationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/BasicConfigurationActivityJava.java))
- Configure logging level ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/SetLogLevelActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/SetLogLevelActivityJava.java))
- Configure data center ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureDataCenterActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureDataCenterActivityJava.java))
- Configure server URL ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureIceServerUrlActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/init/ConfigureIceServerUrlActivityJava.java))

# General tasks

These tasks are common for all communication channels:
- Login user ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/LoginUserActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/LoginUserActivityJava.java))
- Listen for client connection status changes ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/ConnectionStateListenerActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/ConnectionStateListenerActivityJava.java))
- Check if Client is connected ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/IsConnectedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/IsConnectedActivityJava.java))
- Configure Firebase Messaging Service ([Kotlin](app/src/main/java/com/vonage/sample/channel/all/ClientFirebaseMessagingServiceKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/all/ClientFirebaseMessagingServiceJava.java))

# Channels

Android Client SDK supports [Messaging](https://developer.nexmo.com/client-sdk/in-app-messaging/overview) and [Voice](https://developer.nexmo.com/client-sdk/in-app-voice/overview) communication channels.

## Messaging

### Examples

- Load conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationActivityJava.java))
- Create new conversation ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/CreateNewConversationActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/CreateNewConversationActivityJava.java))
- Load conversation events([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationEventsActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/LoadConversationEventsActivityJava.java))
- Load more conversation events, prev/next pages ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/LoadMoreConversationEventsActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/LoadMoreConversationEventsActivityJava.java))
- Send message ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/SendMessageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/SendMessageActivityJava.java))
- Receive message ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveMessageActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/ReceiveMessageActivityJava.java))
- Typing indicator ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/TypingIndicatorActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/TypingIndicatorActivityJava.java))
- Mark message as senn ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/MarkMessageAsSeenActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/MarkMessageAsSeenActivityJava.java))
- Mark message as delivered ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/MarkMessageAsDeliveredActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/MarkMessageAsDeliveredActivityJava.java))
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
- Conversation member updated ([Kotlin](app/src/main/java/com/vonage/sample/channel/messaging/ConversationMemberUpdatedActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/messaging/ConversationMemberUpdatedActivityJava.java))

### More

- Documentation at [API Developer Portal](https://developer.nexmo.com/client-sdk/in-app-messaging/overview)
- Tutorials at [API Developer Portal](https://developer.nexmo.com/client-sdk/tutorials/)
- Main interaction class: [NexmoConversation](https://developer.nexmo.com/sdk/stitch/android/com/nexmo/client/NexmoConversation.html)
- Full [code reference](https://developer.nexmo.com/client-sdk/sdk-documentation/android)

## Voice

The capabilities of `in-app call` are limited, because they doesn't utilize [Voice API](https://developer.nexmo.com/voice/voice-api/overview). This method is recommended mostly for onboarding. Later, it is recommended to use a `server managed call`.

### Examples

- Start in-app call - ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/StartInAppCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/StartInAppCallActivityJava.java))
- Start server managed call ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/StartServerManagedCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/StartServerManagedCallActivityJava.java))
- Receive call events, DTMF ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/ReceiveCallEventsActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/ReceiveCallEventsActivityJava.java))
- Answer incoming call ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/AnswerIncomingCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/AnswerIncomingCallActivityJava.java))
- Hang up call ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/HangupCallActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/HangupCallActivityJava.java))
- Mute call / member / my member ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/MuteActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/MuteActivityJava.java))
- Unmute call / member / my member ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/UnmuteActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/UnmuteActivityJava.java))
- Enable Earmuff / member / my member ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/EnableEarmuffActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/EnableEarmuffActivityJava.java))
- Disable Earmuff / member / my member ([Kotlin](app/src/main/java/com/vonage/sample/channel/voice/DisableEarmuffActivityKotlin.kt), [Java](app/src/main/java/com/vonage/sample/channel/voice/DisableEarmuffActivityJava.java))

### More

- Documentation at [API Developer Portal](https://developer.nexmo.com/client-sdk/in-app-voice/overview)
- Tutorials at [API Developer Portal](https://developer.nexmo.com/client-sdk/tutorials/)
- Main interaction class: [NexmoCall](https://developer.nexmo.com/sdk/stitch/android/com/nexmo/client/NexmoCall.html)
- Full [code reference](https://developer.nexmo.com/client-sdk/sdk-documentation/android)
