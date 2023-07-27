package com.example.data.chats.list.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ChatNetwork(
    val id: String,
    val first_user_id: String,
    val second_user_id: String,
    val created_at: String,
    val lastMessage: String,
    val fullName:String,
    val avatar: String
)