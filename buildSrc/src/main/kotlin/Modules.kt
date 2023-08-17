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
        const val chats_list = ":feature-chat-list"
        const val add_chat = ":feature-chat-add"
        const val chat_dialog = ":feature-chat-dialog"
        const val authorization = ":feature-authorization"
        const val profile = ":feature-profile"
    }

    object Data {
        const val core = ":core:core-data"

        const val characters = "${Feature.characters}:data"
        const val chats_list = "${Feature.chats_list}:data"
        const val add_chat = "${Feature.add_chat}:data"
        const val chat_dialog = "${Feature.chat_dialog}:data"
        const val authorization = "${Feature.authorization}:data"
        const val profile = "${Feature.profile}:data"
    }

    object Domain {
        const val core = ":core:core-domain"

        const val characters = "${Feature.characters}:domain"
        const val chats_list = "${Feature.chats_list}:domain"
        const val add_chat = "${Feature.add_chat}:domain"
        const val chat_dialog = "${Feature.chat_dialog}:domain"
        const val authorization = "${Feature.authorization}:domain"
        const val profile = "${Feature.profile}:domain"
    }

}