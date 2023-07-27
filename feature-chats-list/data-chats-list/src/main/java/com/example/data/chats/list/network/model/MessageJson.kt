package com.example.data.chats.list.network.model

data class MessageJson(
    val id:String,
    val id_chat: String,
    val message: String,
    val created_at: String,
    val id_user: String
)
