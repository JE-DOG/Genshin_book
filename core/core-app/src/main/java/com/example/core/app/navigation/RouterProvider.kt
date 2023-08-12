package com.example.core.app.navigation

import com.github.terrakok.cicerone.Screen

interface ScreenProvider {

    fun chatsList(): Screen

    fun addChat(): Screen

    fun chat(
        chatId: String
    ): Screen

    companion object {

        const val CHAT_ID_KEY = "ChatIdKey"

    }
}