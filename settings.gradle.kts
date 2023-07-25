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
include(":core-data")
include(":core-domain")
include(":domain-characters")
include(":core")
include(":data-characters")
include(":core-feature")
include(":feature-characters")
include(":feature-main")
include(":feature-characters-detail")
