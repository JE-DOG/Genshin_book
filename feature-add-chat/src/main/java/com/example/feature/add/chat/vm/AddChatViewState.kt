package com.example.feature.add.chat.vm

import com.example.feature.add.chat.model.Profile

data class AddChatViewState(
    val users: MutableList<Profile> = mutableListOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val chatId: String? = null,
    val update: Boolean = false
)