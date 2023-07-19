plugins {
    id("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("io.realm.kotlin")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.2")
//    implementation ("androidx.compose.ui:ui:$compose_ui_version")
//    implementation ("androidx.compose.ui:ui-tooling-preview:$compose_ui_version")
    implementation ("androidx.compose.material:material:1.4.3")
    implementation ("androidx.compose.material3:material3:1.1.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")


    //Tests
    //mockito
    val mockito_version = "4.0.0"
    testImplementation ("org.mockito:mockito-core:$mockito_version")
    testImplementation ("org.mockito.kotlin:mockito-kotlin:$mockito_version")
    testImplementation ("org.mockito:mockito-inline:$mockito_version")
    //j-unit
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    testImplementation ("junit:junit:4.13.2")
    //ui
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
//    debugImplementation ("androidx.compose.ui:ui-tooling:$compose_ui_version")
//    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$compose_ui_version")
//    debugImplementation ("androidx.compose.ui:ui-test-manifest:$compose_ui_version")
    //android
    testImplementation ("androidx.arch.core:core-testing:2.2.0")

    //di
    val dagger_version = "2.44.2"
    //dagger
    implementation ("com.google.dagger:dagger:$dagger_version")
    kapt ("com.google.dagger:dagger-compiler:$dagger_version")

    //network
    //Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //OkHttp
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.9")

    //navigation
    val voyagerVersion = "1.0.0-rc05"
    // Voyager
    implementation ("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
    // TabNavigator
    implementation ("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")


    // ViewModel
    val lifecycle_version = "2.4.0"
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    //live data
    implementation ("androidx.compose.runtime:runtime-livedata:1.6.0-alpha01")

    //storage
    //Realm
    implementation ("io.realm.kotlin:library-base:1.8.0")

}