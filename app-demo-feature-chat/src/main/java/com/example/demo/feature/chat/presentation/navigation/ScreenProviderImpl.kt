package com.example.demo.feature.chat.presentation.navigation

import com.example.core.app.navigation.ScreenProvider
import com.example.demo.feature.chat.R
import com.example.feature.add.chat.FragmentAddChat
import com.example.feature.chats.list.ChatsListFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreenProviderImpl: ScreenProvider {

    override fun chatsList() = FragmentScreen {
        ChatsListFragment()
    }

    override fun addChat(): Screen {
        TODO("Not yet implemented")
    }

    override fun chat(chatId: String) = FragmentScreen {
        FragmentAddChat().apply {

            arguments?.apply {

                val chatIdKey = resources.getString(com.example.core.R.string.chat_id)
                putString(
                    chatIdKey,chatId
                )

            }

        }
    }
}