plugins {
    id(Plugins.Android.library)
    id (Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.Another.Realm.realm)
}

android {
    namespace = "com.example.data.characters"
    compileSdk = 34

    defaultConfig {
        minSdk = 29
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    implementation ( project(Modules.Data.core) )
    implementation ( project(Modules.Domain.characters) )

    kapt ( Dependencies.Another.DI.Dagger.compiler )

}