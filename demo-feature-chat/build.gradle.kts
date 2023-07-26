plugins {
    id(Plugins.Android.application)
    id(Plugins.Kotlin.android)
}

android {
    namespace = "com.example.demo.feature.chat"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.demo_feature_chat"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation( project(Modules.App.core) )
    implementation( project(Modules.core) )

}