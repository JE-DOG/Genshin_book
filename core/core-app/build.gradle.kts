plugins {
    id (Plugins.Android.library)
    id (Plugins.Kotlin.android)
}

android {
    namespace = "com.example.core.app"
    compileSdk = 34

    defaultConfig {
        minSdk = 29
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    api ( project(Modules.core) )

    api (Dependencies.AndroidX.LifeCycle.runtime_ktx)
    api (Dependencies.AndroidX.Core.ktx)
    api (Dependencies.AndroidX.Activity.compose)
    api (Dependencies.Test.Coroutine.coroutine_test)

    //compose
    api (Dependencies.Compose.ui)
    api (Dependencies.Compose.Material2.material2)
    api (Dependencies.Compose.Material3.material3)
    api (Dependencies.Compose.ui_tooling_preview)
    api (Dependencies.Another.PictureLoader.Coil.coil_compose)

    //xml
    //materials
    api (Dependencies.XML.Material2.material2)
    api (Dependencies.XML.Material3.material3)
    //app compat
    api (Dependencies.XML.AppCompat.app_compat)
    //navigation
    api (Dependencies.XML.Navigation.Cicerone.cicerone)
    //Jetpack
    api (Dependencies.AndroidX.Activity.xml)
    api (Dependencies.AndroidX.Fragment.xml)
    //Coil
    api (Dependencies.Another.PictureLoader.Coil.coil_xml)

    //lifecycle
    api (Dependencies.AndroidX.LifeCycle.viewmodel_compose)

    //navigation
    // Voyager
    api (Dependencies.Compose.Navigation.Voyager.navigator)
    api (Dependencies.Compose.Navigation.Voyager.tab_navigator)
    
    // ViewModel
    api (Dependencies.Compose.LiveData.runtime)

    //RxJava
    api (Dependencies.Another.MultiThreading.RxJava2.android)

}