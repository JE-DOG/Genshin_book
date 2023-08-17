package com.example.feature.chat.dialog.domain.model

data class MessageDomain(
    val id: String? = null,
    val chatId: String,
    val message: String,
    val createdAt: String,
    val userId: String
)