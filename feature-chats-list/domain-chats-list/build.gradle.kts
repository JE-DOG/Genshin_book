plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
    id(Plugins.Kotlin.kapt)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    api ( project(Modules.Domain.core) )

    kapt (Dependencies.Another.DI.Dagger.compiler)

    implementation( platform(Dependencies.Another.Network.Supabase.bom) )
    implementation(Dependencies.Another.Network.Supabase.realtime)

}