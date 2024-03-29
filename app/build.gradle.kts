plugins {
    id (Plugins.Android.application)
    id (Plugins.Kotlin.android)
    id (Plugins.Kotlin.kapt)
}

android {
    namespace = "com.example.genshinbook"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.genshinbook"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //include modules
    implementation ( project(path = Modules.App.core) )

    implementation ( project(Modules.Feature.main) )
    implementation ( project(Modules.Feature.chats_list) )
    implementation ( project(Modules.Feature.chat_dialog) )
    implementation ( project(Modules.Feature.add_chat) )
    implementation ( project(Modules.Feature.profile) )
    implementation ( project(Modules.Feature.authorization) )


    //dagger compiler
    kapt (Dependencies.Another.DI.Dagger.compiler)

}