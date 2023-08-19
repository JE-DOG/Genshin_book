package com.example.feature.chats.list.vm

import com.example.feature.chats.list.model.Chat

data class ChatsListViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val chats: MutableList<Chat> = mutableListOf(),
    val update: Boolean = false
)
