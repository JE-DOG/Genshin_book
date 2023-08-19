package com.example.data.core.supabase

object Tables {

    object CHATS {
        const val tableName = "chats"

        const val id = "id"

        const val first_user_id = "first_user_id"
        const val second_user_id = "second_user_id"
        const val created_at = "created_at"
    }

    object MESSAGES {
        const val tableName = "messages"

        const val id = "id"
        const val chat_id = "id_chat"
        const val message = "message"
        const val created_at = "created_at"
        const val user_id = "id_user"
    }

    object PROFILES {
        const val tableName = "profiles"

        const val id = "id"
        const val created_at = "created_at"
        const val fullName = "fullname"
        const val avatar = "avatar"
    }

}