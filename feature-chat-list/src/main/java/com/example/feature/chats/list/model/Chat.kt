package com.example.feature.chats.list.model

import com.example.core.app.ui.xml.base.rcv.RecyclerItem
import com.example.domain.chats.list.model.ChatDomain
import kotlinx.serialization.Serializable

@Serializable
data class Chat(
    val id: String,
    val first_user_id: String,
    val second_user_id: String,
    val created_at: String,
    val lastMessage: String?,
    val fullName:String,
    val avatar: String
): RecyclerItem {

    companion object {

        fun fromDomain(
            chatDomain: ChatDomain
        ): Chat {
            chatDomain.run {
                return Chat(
                    id = id,
                    first_user_id = first_user_id,
                    second_user_id = second_user_id,
                    created_at = created_at,
                    lastMessage = lastMessage,
                    fullName = fullName,
                    avatar = avatar
                )
            }
        }

    }
}
