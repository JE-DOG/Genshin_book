plugins {
    id(Plugins.Android.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.example.feature.characters"
    compileSdk = 34

    defaultConfig {
        minSdk = 29
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    api ( project(Modules.Feature.core) )
    api ( project(path = Modules.Data.characters) )
    api ( project(path = Modules.Domain.characters) )

    kapt ( Dependencies.Another.DI.Dagger.compiler )

    //j-unit
    androidTestImplementation (Dependencies.Test.Junit.ext_junit)
    //ui
    debugImplementation (Dependencies.Compose.ui_tooling)
    androidTestImplementation (Dependencies.Compose.ui_test_junit4)
    debugImplementation (Dependencies.Compose.ui_test_manifest)
    //android
    testImplementation (Dependencies.Test.AndroidX.Core.core_testing)
    androidTestImplementation (Dependencies.Test.AndroidX.Espresso.core)

    //Tests
    //mockito
    testImplementation (Dependencies.Test.Mockito.core)
    testImplementation (Dependencies.Test.Mockito.kotlin)
    testImplementation (Dependencies.Test.Mockito.inline)
    //j-unit
    testImplementation (Dependencies.Test.Junit.junit)


}