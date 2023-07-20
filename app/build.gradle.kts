plugins {
    id (Plugins.Android.application)
    id (Plugins.Kotlin.android)
    id (Plugins.Kotlin.kapt)
    id (Plugins.Another.Realm.realm)
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation (Dependencies.AndroidX.LifeCycle.runtime_ktx)
    implementation (Dependencies.AndroidX.LifeCycle.viewmodel_compose)
    implementation (Dependencies.AndroidX.Core.ktx)
    implementation (Dependencies.AndroidX.Activity.compose)
    implementation (Dependencies.Compose.ui)
    implementation (Dependencies.Compose.ui_tooling_preview)
    implementation (Dependencies.Compose.Material2.material2)
    implementation (Dependencies.Compose.Material3.material3)
    implementation (Dependencies.Test.Coroutine.coroutine)

    //xml
    //material 2
    implementation (Dependencies.XML.Material2.material2)
    //app compat
    implementation (Dependencies.XML.AppCompat.app_compat)
    //navigation
    implementation (Dependencies.XML.Navigation.Cicerone.cicerone)


    //Tests
    //mockito
    testImplementation (Dependencies.Test.Mockito.core)
    testImplementation (Dependencies.Test.Mockito.kotlin)
    testImplementation (Dependencies.Test.Mockito.inline)
    //j-unit
    androidTestImplementation (Dependencies.Test.Junit.ext_junit)
    testImplementation (Dependencies.Test.Junit.junit)
    //ui
    debugImplementation (Dependencies.Compose.ui_tooling)
    androidTestImplementation (Dependencies.Compose.ui_test_junit4)
    debugImplementation (Dependencies.Compose.ui_test_manifest)
    //android
    testImplementation (Dependencies.Test.AndroidX.Core.core_testing)
    androidTestImplementation (Dependencies.Test.AndroidX.Espresso.core)

    //di
    //dagger
    implementation (Dependencies.Another.DI.Dagger.dagger)
    kapt (Dependencies.Another.DI.Dagger.compiler)

    //network
    //Retrofit
    implementation (Dependencies.Another.Network.Retrofit.gson)
    implementation (Dependencies.Another.Network.Retrofit.retrofit)
    //OkHttp
    implementation (Dependencies.Another.Network.OkHttp.okhttp)
    implementation (Dependencies.Another.Network.OkHttp.interceptor)

    //navigation
    // Voyager
    implementation (Dependencies.Compose.Navigation.Voyager.navigator)
    implementation (Dependencies.Compose.Navigation.Voyager.tab_navigator)


    // ViewModel
    implementation (Dependencies.Compose.LiveData.runtime)

    //storage
    //Realm
    implementation (Dependencies.Another.Database.Realm.base)

}