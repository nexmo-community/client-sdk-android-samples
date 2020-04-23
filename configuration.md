# Base configuration

## Add Android Client SDK dependency

[![Android Nexmo Client-SDK version](https://img.shields.io/maven-central/v/com.nexmo.android/client-sdk.svg)](https://repo.maven.apache.org/maven2/com/nexmo/android/client-sdk/)

Kotlin:
```
implementation("com.nexmo.android:client-sdk:x.y.z")
```

Groovy:
```
implementation 'com.nexmo.android:client-sdk:x.y.z'
```

## Initialize the client

The best place to initialize the client is custom Android [Application](https://developer.android.com/reference/android/app/Application) class:

Kotlin
```
// BaseApplication.kt

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        // Init the NexmoClient. You can retrieve NexmoClient instance latter by using NexmoClient.get()
        NexmoClient.Builder().build(this)
    }
}
```


Java
```
// BaseApplication.java

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Init the NexmoClient. You can retrieve NexmoClient instance latter by using NexmoClient.get()
        new NexmoClient.Builder().build(this);
    }
}
```

We need to add custom `BaseApplication` to the `AndroidManifest.xml` file (typically `app/src/main/AndroidManifest.xml`):
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

## Permissions

Add required permissions to `AndroidManifest.xml` file (typically `app/src/main/AndroidManifest.xml`):
```
<manifest ...>
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS" />
    <uses-permission android:name="android.permission.RECORD_AUDIO" />
</manifest>
```

Request permissions at runtime (when needed):

Kotlin
```
// Here, thisActivity is the current activity
if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
    ActivityCompat.requestPermissions(thisActivity, arrayOf(Manifest.permission.RECORD_AUDIO), 123)
}
```

Java
```
// Here, thisActivity is the current activity
if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
    ActivityCompat.requestPermissions(thisActivity, new String[]{Manifest.permission.RECORD_AUDIO}, 123);
}
```