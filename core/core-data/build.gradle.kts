plugins {
    id(Plugins.Android.library)
    id(Plugins.Kotlin.android)
}

android {
    namespace = "com.example.data.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.ext.junit.runners.AndroidJUnit4"
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
}

dependencies { 
    
    api( project(Modules.core) )

    //storage
    //Realm
    api (Dependencies.Another.Database.Realm.base)
    //Room
    api (Dependencies.Another.Database.Room.ktx)
    api (Dependencies.Another.Database.Room.runtime)
    api (Dependencies.Another.Database.Room.rx_java)

    //network
    //Retrofit
    api (Dependencies.Another.Network.Retrofit.gson)
    api (Dependencies.Another.Network.Retrofit.retrofit)
    api (Dependencies.Another.Network.Retrofit.rx_java_adapter)
    //OkHttp
    api (Dependencies.Another.Network.OkHttp.okhttp)
    api (Dependencies.Another.Network.OkHttp.interceptor)

    //supabase
    api ( platform(Dependencies.Another.Network.Supabase.bom) )
    api ( Dependencies.Another.Network.Supabase.postgrest )
    api ( Dependencies.Another.Network.Supabase.realtime )

    //ktor
    api ( Dependencies.Another.Network.Ktor.ktor )

}