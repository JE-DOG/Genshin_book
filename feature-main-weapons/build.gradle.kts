plugins {
    id(Plugins.Android.library)
    id(Plugins.Kotlin.android)
}

android {
    namespace = "com.example.feature.main.weapons"
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
    buildFeatures {
        compose = true
    }
}

dependencies {

    api ( project(Modules.core) )
    api ( project(Modules.Feature.core) )
    api ( project(Modules.Domain.main_weapon) )
    api ( project(Modules.Data.main_weapon) )

}