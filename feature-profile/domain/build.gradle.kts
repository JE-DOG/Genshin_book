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

    api ( project(Modules.core) )
    api ( project(Modules.Domain.core) )

    api ( project(Modules.Domain.add_chat) )

    kapt (Dependencies.Another.DI.Dagger.compiler)

}