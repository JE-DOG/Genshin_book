package com.example.demo.feature.chat.presentation.navigation

import android.os.Bundle
import com.example.core.app.navigation.ScreenProvider
import com.example.demo.feature.chat.R
import com.example.feature.add.chat.FragmentAddChat
import com.example.feature.chat.dialog.ChatDialogFragment
import com.example.feature.chats.list.ChatsListFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreenProviderImpl: ScreenProvider {

    override fun chatsList() = FragmentScreen {
        ChatsListFragment()
    }

    override fun addChat() = FragmentScreen {
        FragmentAddChat()
    }

    override fun chat(
        chatId: String
    ) = FragmentScreen {
        val bundle = Bundle().apply {
            putString(ScreenProvider.CHAT_ID_KEY,chatId)
        }

        ChatDialogFragment().apply {

            arguments = bundle

        }
    }
}