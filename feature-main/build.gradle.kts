plugins {
    id(Plugins.Android.library)
    id(Plugins.Kotlin.android)
}

android {
    namespace = "com.example.feature.main"
    compileSdk = 34

    defaultConfig {
        minSdk = 29
        targetSdk = 34

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
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }
}

dependencies {

    api ( project(Modules.Feature.core) )

    //characters
    api ( project(path = Modules.Feature.characters) )
    api ( project(path = Modules.Feature.characters_detail) )
    api ( project(path = Modules.Feature.main_weapon) )

}