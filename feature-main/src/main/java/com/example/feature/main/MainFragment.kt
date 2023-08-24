package com.example.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import cafe.adriel.voyager.navigator.Navigator
import com.example.core.app.ui.compose.theme.GenshinBookTheme

class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                GenshinBookTheme {
                    Navigator(MainScreen())
                }
            }
        }
    }

}