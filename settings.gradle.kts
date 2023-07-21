pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Genshin book"

include(":app")
include(":core-app")
//data
include(":data-core")
//domain
include(":domain-core")
include(":domain-characters")
include(":core")
include(":data-characters")
