plugins {
    id(Plugins.Android.library)
    id(Plugins.Kotlin.android)
}

android {
    namespace = "com.example.feature.profile"
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
    api ( project(Modules.Feature.core) )
    api ( project(Modules.Feature.add_chat) )

    api ( project(Modules.Data.profile) )
    api ( project(Modules.Domain.profile) )


}