plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    api ( project(Modules.core) )
    api ( project(Modules.Domain.core) )
    api ( project(Modules.Domain.add_chat) )

    implementation( platform(Dependencies.Another.Network.Supabase.bom) )
    implementation(Dependencies.Another.Network.Supabase.realtime)

}