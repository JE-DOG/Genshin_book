package com.example.data.chats.list.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ChatJson(
    val id: String = "",
    val first_user_id: String = "",
    val second_user_id: String = "",
    val created_at: String = ""
)