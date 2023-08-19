package com.example.data.chats.list.network.model

import kotlinx.serialization.Serializable

@Serializable
data class MessageJson(
    val id:String,
    val id_chat: String,
    val message: String,
    val created_at: String,
    val id_user: String
)
