buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
    }
}
//don't helped
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}

plugins {
    id (Plugins.Android.application) version Plugins.Android.version apply false
    id (Plugins.Android.library) version Plugins.Android.version apply false
    id (Plugins.Kotlin.android) version Plugins.Kotlin.version apply false
    //realm
    id (Plugins.Another.Realm.realm) version Plugins.Another.Realm.version apply false
 }