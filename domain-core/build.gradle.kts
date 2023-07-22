plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
    id(Plugins.Another.Realm.realm)

}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
kotlin {
    jvmToolchain(17)
}

dependencies {

    api ( project(Modules.core) )

}