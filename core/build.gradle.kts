plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    //di
    //dagger
    api (Dependencies.Another.DI.Dagger.dagger)

    //Tests
    //mockito
    testApi (Dependencies.Test.Mockito.core)
    testApi (Dependencies.Test.Mockito.kotlin)
    testApi (Dependencies.Test.Mockito.inline)
    //j-unit
    testApi (Dependencies.Test.Junit.junit)
    
}