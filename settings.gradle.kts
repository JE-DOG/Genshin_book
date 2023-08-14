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
include(":feature-characters:domain")
include(":core")
include(":feature-characters:data")
include(":core:core-feature")
include(":feature-characters")
include(":feature-main")
include(":feature-characters-detail")
include(":app-demo-feature-chat")
include(":feature-chat-list:domain")
include(":feature-chat-list:data")
include(":feature-chat-list")
include(":feature-chat-add")
include(":feature-chat-add:domain")
include(":feature-chat-add:data")
include(":feature-chat-dialog")
include(":feature-main:domain")
include(":feature-main:data")
include(":feature-chat-dialog:domain")
include(":feature-chat-dialog:data")
include(":app-demo-authorization")
include(":feature-authorization")
include(":feature-authorization:domain")
include(":feature-authorization:data")
