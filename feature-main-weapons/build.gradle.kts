plugins {
    id(Plugins.Android.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
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
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }
}

dependencies {

    api ( project(Modules.core) )
    api ( project(Modules.Feature.core) )
    api ( project(Modules.Domain.main_weapon) )
    api ( project(Modules.Data.main_weapon) )

    kapt (Dependencies.Another.DI.Dagger.compiler)

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