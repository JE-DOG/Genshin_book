package com.example.feature.chat.dialog.vm

import com.example.feature.add.chat.model.Profile
import com.example.feature.chat.dialog.model.Message

data class ChatDialogViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val update: Boolean = false,
    val messages: MutableList<Message> = mutableListOf(),
    val profile: Profile? = null
)