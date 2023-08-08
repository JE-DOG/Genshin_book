package com.example.feature.add.chat.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ProfileJson(
    val id: String,
    val created_at: String,
    val fullname: String,
    val avatar: String
)
