package com.example.genshinbook.presentaion.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.core.feature.screen.ComposeMainScreensNavigation
import com.example.feature.characters.model.Character
import com.example.genshinbook.presentaion.screen.detail.CharacterDetailScreen

class ComposeMainScreensNavigationImpl: ComposeMainScreensNavigation {

    override val navigator: Navigator
        @Composable
        get() {
            val navigator = LocalNavigator.currentOrThrow
            return navigator
        }

    override fun <T : Any> characterDetail(value: T): Screen {
        return CharacterDetailScreen(value as Character)
    }
}