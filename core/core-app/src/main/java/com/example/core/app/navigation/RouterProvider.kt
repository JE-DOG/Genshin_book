package com.example.core.app.navigation

import com.github.terrakok.cicerone.Screen

interface ScreenProvider {

    fun main(): Screen

    fun chatsList(): Screen

    fun addChat(): Screen

    fun chat(
        chatId: String
    ): Screen

    fun signIn(): Screen

    fun signUp(): Screen

    companion object {

        const val CHAT_ID_KEY = "ChatIdKey"

    }
}