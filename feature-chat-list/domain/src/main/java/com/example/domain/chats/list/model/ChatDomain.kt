package com.example.domain.chats.list.model

import kotlinx.serialization.Serializable

@Serializable
data class ChatDomain(
    val id: String,
    val first_user_id: String,
    val second_user_id: String,
    val created_at: String,
    val lastMessage: String?,
    val fullName:String,
    val avatar: String
)
