package com.example.feature.add.chat.data.network.model

import com.example.add.chat.domain.model.ProfileDomain
import kotlinx.serialization.Serializable

@Serializable
data class ProfileJson(
    val id: String,
    val created_at: String,
    val fullname: String,
    val avatar: String
) {

    fun toDomain(): ProfileDomain {
        return ProfileDomain(
            id,
            created_at,
            fullname,
            avatar
        )
    }

}
