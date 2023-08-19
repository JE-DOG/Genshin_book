plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    api (Dependencies.Kotlin.coroutines_core)

    //di
    //dagger
    api (Dependencies.Another.DI.Dagger.dagger)

}