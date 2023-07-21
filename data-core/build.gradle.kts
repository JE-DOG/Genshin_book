plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies { 
    
    api( project(Modules.core) )

    //storage
    //Realm
    api (Dependencies.Another.Database.Realm.base)

    //network
    //Retrofit
    api (Dependencies.Another.Network.Retrofit.gson)
    api (Dependencies.Another.Network.Retrofit.retrofit)
    //OkHttp
    api (Dependencies.Another.Network.OkHttp.okhttp)
    api (Dependencies.Another.Network.OkHttp.interceptor)
    
}