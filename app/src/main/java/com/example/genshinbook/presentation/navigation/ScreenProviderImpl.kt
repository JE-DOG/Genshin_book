package com.example.genshinbook.presentation.navigation

import android.os.Bundle
import com.example.core.app.navigation.ScreenProvider
import com.example.feature.add.chat.FragmentAddChat
import com.example.feature.authorization.screen.sign_in.SignInFragment
import com.example.feature.authorization.screen.sign_up.SignUpFragment
import com.example.feature.chat.dialog.ChatDialogFragment
import com.example.feature.chats.list.ChatsListFragment
import com.example.feature.main.MainFragment
import com.example.feature.profile.ProfileFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreenProviderImpl: ScreenProvider {

    override fun main() = FragmentScreen {
        MainFragment()
    }

    override fun chatsList() = FragmentScreen {
        ChatsListFragment()
    }

    override fun addChat() = FragmentScreen {
        FragmentAddChat()
    }

    override fun chat(chatId: String) = FragmentScreen {
        val bundle = Bundle().apply {
            putString(ScreenProvider.CHAT_ID_KEY,chatId)
        }

        ChatDialogFragment().apply {

            arguments = bundle

        }
    }

    override fun signIn() = FragmentScreen {
        SignInFragment()
    }

    override fun signUp() = FragmentScreen {
        SignUpFragment()
    }

    override fun profile() = FragmentScreen {
        ProfileFragment()
    }
}