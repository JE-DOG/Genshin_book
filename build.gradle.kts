buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
    }
}

plugins {
    id (Plugins.Android.application) version Plugins.Android.version apply false
    id (Plugins.Android.library) version Plugins.Android.version apply false
    id (Plugins.Kotlin.android) version Plugins.Kotlin.version apply false
    kotlin (Plugins.Kotlin.serialization) version Plugins.Kotlin.version apply false
    //realm
    id (Plugins.Another.Realm.realm) version Plugins.Another.Realm.version apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.0" apply false
}