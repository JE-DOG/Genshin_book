plugins {
    id(Plugins.Android.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.example.app_demo_authorization"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.app.demo.authorization"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation ( project(Modules.core) )
    implementation ( project(Modules.App.core) )

    kapt(Dependencies.Another.DI.Dagger.compiler)

}