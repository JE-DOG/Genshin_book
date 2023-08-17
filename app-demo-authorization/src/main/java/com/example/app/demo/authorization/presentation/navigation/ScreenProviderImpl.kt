package com.example.app.demo.authorization.presentation.navigation

import com.example.core.app.navigation.ScreenProvider
import com.example.feature.authorization.screen.sign_in.SignInFragment
import com.example.feature.authorization.screen.sign_up.SignUpFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreenProviderImpl: ScreenProvider {

    override fun chatsList(): Screen {
        TODO("Not yet implemented")
    }

    override fun addChat(): Screen {
        TODO("Not yet implemented")
    }

    override fun chat(chatId: String): Screen {
        TODO("Not yet implemented")
    }

    override fun signIn() = FragmentScreen {
        SignInFragment()
    }

    override fun signUp() = FragmentScreen {
        SignUpFragment()
    }

    override fun main(): Screen {
        TODO("Not yet implemented")
    }
}