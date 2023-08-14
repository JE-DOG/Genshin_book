package com.example.feature.authorization.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthorizationProfileJson(
    val id: String,
    val created_at: String? = null,
    val fullname: String,
    val avatar: String = "",

)