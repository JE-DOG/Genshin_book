plugins {
    id(Plugins.Android.library)
    id(Plugins.Kotlin.android)
    kotlin (Plugins.Kotlin.serialization)
}

android {
    namespace = "com.example.feature.chat.dialog.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    api ( project(Modules.core) )
    api ( project(Modules.Data.core) )
    api ( project(Modules.Data.add_chat) )
    api ( project(Modules.Data.chats_list) )
    api ( project(Modules.Domain.chat_dialog) )

}