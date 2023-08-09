package com.example.feature.chat.dialog.data.network.model

import com.example.faeture.chat.dialog.domain.model.MessageDomain

data class MessageJson(
    val id: String,
    val id_chat: String,
    val message: String,
    val created_at: String,
    val id_user: String
){

    fun toDomain(): MessageDomain {
        return MessageDomain(
            id = id,
            chatId = id_chat,
            message = message,
            createdAt = created_at,
            userId = id_user
        )


    }

    companion object {

        fun fromDomain(
            messageDomain: MessageDomain
        ): MessageJson {
            messageDomain.run {

                return MessageJson(
                    id = id,
                    id_chat = chatId,
                    message = message,
                    created_at = createdAt,
                    id_user = userId
                )

            }
        }

    }
}
