package com.example.feature.chat.dialog.model

import com.example.core.app.base.rcv.RecyclerItem
import com.example.faeture.chat.dialog.domain.model.MessageDomain
import com.example.feature.chat.dialog.data.network.model.MessageJson

data class Message(
    val id: String? = null,
    val chatId: String,
    val message: String,
    val createdAt: String = "",
    val userId: String
): RecyclerItem {

    fun toDomain(): MessageDomain {

        return MessageDomain(
            id = id,
            chatId = chatId,
            message = message,
            createdAt = createdAt,
            userId = userId
        )

    }

    companion object {

        fun fromDomain(
            messageDomain: MessageDomain
        ): Message {

            messageDomain.run {

                return Message(
                    id = id,
                    chatId = chatId,
                    message = message,
                    createdAt = createdAt,
                    userId = userId
                )

            }

        }

        fun fromJson(
            messageJson: MessageJson
        ): Message {

            messageJson.run {

                return Message(
                    id = id,
                    chatId = id_chat,
                    message = message,
                    createdAt = created_at,
                    userId = id_user
                )

            }

        }


    }
}
