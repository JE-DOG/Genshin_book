package com.example.genshinbook

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.example.genshinbook.presentaion.screen.main.MainScreen
import com.example.genshinbook.presentaion.ui.theme.GenshinBookTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GenshinBookTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    Modifier
                        .fillMaxSize(),
                ) {
                    Navigator(screen = MainScreen())
                }
            }
        }
    }
}
