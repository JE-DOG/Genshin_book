package com.example.data.chats.list.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ProfileJson(
    val id: String,
    val created_at: String,
    val fullname: String,
    val avatar: String
)
