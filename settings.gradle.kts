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
include(":core:core-app")
include(":core:core-data")
include(":core:core-domain")
include(":feature-characters:domain-characters")
include(":core")
include(":feature-characters:data-characters")
include(":core:core-feature")
include(":feature-characters")
include(":feature-main")
include(":feature-characters-detail")
include(":app-demo-feature-chat")
include(":feature-chats-list:domain-chats-list")
include(":feature-chats-list:data-chats-list")
include(":feature-chats-list")
include(":feature-add-chat")
include(":feature-add-chat:domain")
