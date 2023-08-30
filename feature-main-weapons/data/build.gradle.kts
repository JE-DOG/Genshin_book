plugins {
    id(Plugins.Android.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.example.feature.main.weapons.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.ext.junit.runners.AndroidJUnit4"
        consumerProguardFiles("consumer-rules.pro")

        kapt {
            arguments {
                arg(
                    "room.schemaLocation",
                    "$projectDir/schemas"
                )
            }
        }
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
    api ( project(Modules.Domain.main_weapon) )


    //Room
    kapt (Dependencies.Another.Database.Room.compiler)
    
    //Tests

    //j-unit
    testImplementation (Dependencies.Test.Junit.ext_junit)
    testImplementation (Dependencies.Test.Junit.junit)
    //ui
    debugImplementation (Dependencies.Compose.ui_tooling)
    androidTestImplementation (Dependencies.Compose.ui_test_junit4)
    debugImplementation (Dependencies.Compose.ui_test_manifest)
    //android
    testImplementation (Dependencies.Test.AndroidX.Core.core_testing)
    androidTestImplementation (Dependencies.Test.AndroidX.Espresso.core)
    //mockito
    testImplementation (Dependencies.Test.Mockito.core)
    testImplementation (Dependencies.Test.Mockito.kotlin)
    testImplementation (Dependencies.Test.Mockito.inline)
}