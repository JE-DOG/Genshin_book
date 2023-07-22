plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
    id(Plugins.Kotlin.kapt)
    id(Plugins.Another.Realm.realm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
//don't helped
kotlin {
    jvmToolchain(17)
}

dependencies {

    implementation ( project(Modules.Data.core) )
    implementation ( project(Modules.Domain.characters) )
    kapt ( Dependencies.Another.DI.Dagger.compiler )

}