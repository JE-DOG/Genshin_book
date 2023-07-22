plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
    id(Plugins.Kotlin.kapt)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
kotlin {
    jvmToolchain(17)
}

dependencies {

    implementation( project(Modules.Domain.core) )
    kapt (Dependencies.Another.DI.Dagger.compiler)

}