object Modules {

    const val core = ":core"

    object App {
        const val app = ":app"

        const val core = ":core:core-app"
    }

    object Feature {
        const val core = ":core:core-feature"

        const val main = ":feature-main"
        const val characters = ":feature-characters"
        const val characters_detail = ":feature-characters-detail"
        const val chats_list = ":feature-chats-list"
        const val add_chat = ":feature-add-chat"
    }

    object Data {
        const val core = ":core:core-data"

        const val characters = "${Feature.characters}:data-characters"
        const val chats_list = "${Feature.chats_list}:data-chats-list"
        const val add_chat = "${Feature.add_chat}:data"

    }

    object Domain {
        const val core = ":core:core-domain"

        const val characters = "${Feature.characters}:domain-characters"
        const val chats_list = "${Feature.chats_list}:domain-chats-list"
        const val add_chat = "${Feature.add_chat}:domain"
    }

}