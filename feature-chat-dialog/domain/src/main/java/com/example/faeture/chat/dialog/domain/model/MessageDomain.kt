package com.example.faeture.chat.dialog.domain.model

data class MessageDomain(
    val id: String,
    val chatId: String,
    val message: String,
    val createdAt: String,
    val userId: String
)