package com.example.domain.chats.list.di

import com.example.domain.chats.list.ChatsListRepository

interface DomainChatsListDeps {

    val userId: String

    val chatsListRepository: ChatsListRepository

}