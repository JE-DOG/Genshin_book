package com.example.core.feature.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator

interface ComposeMainScreensNavigation {

    val navigator: Navigator
        @Composable get

    fun<T: Any> characterDetail(value: T): Screen
    
}


