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
include(":core-data")
//domain
include(":core-domain")
include(":domain-characters")
include(":core")
include(":data-characters")
include(":core-feature")
include(":feature-characters")
