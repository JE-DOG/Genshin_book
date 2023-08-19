package com.example.data.chats.list.network.model

import com.example.domain.chats.list.model.ChatDomain
import kotlinx.serialization.Serializable

@Serializable
data class ChatNetwork(
    val id: String,
    val first_user_id: String,
    val second_user_id: String,
    val created_at: String,
    val lastMessage: String?,
    val fullName:String,
    val avatar: String
) {

    fun toDomain() = ChatDomain(
        id = id,
        first_user_id = first_user_id,
        second_user_id = second_user_id,
        created_at = created_at,
        lastMessage = lastMessage,
        fullName = fullName,
        avatar = avatar
    )

}