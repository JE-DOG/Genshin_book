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

    //Tests
    //mockito
    testImplementation (Dependencies.Test.Mockito.core)
    testImplementation (Dependencies.Test.Mockito.kotlin)
    testImplementation (Dependencies.Test.Mockito.inline)
    //j-unit
    testImplementation (Dependencies.Test.Junit.junit)
    
}