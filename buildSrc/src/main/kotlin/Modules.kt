object Modules {

    const val core = ":core"

    object App {
        const val app = ":app"

        const val core = ":core-app"
    }

    object Feature {
        const val core = ":core-feature"

        const val main = ":feature-main"
        const val characters = ":feature-characters"
        const val characters_detail = ":feature-characters-detail"
    }

    object Data {
        const val core = ":core-data"

        const val characters = ":data-characters"
    }

    object Domain {
        const val core = ":core-domain"

        const val characters = ":domain-characters"
        const val chats_list = ":domain-chats-list"
    }

}