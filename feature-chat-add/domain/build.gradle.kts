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
    api ( project(Modules.Domain.chats_list) )

}