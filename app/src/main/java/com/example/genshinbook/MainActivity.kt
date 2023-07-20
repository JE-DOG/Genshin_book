package com.example.genshinbook

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.example.genshinbook.core.ext.isNull
import com.example.genshinbook.databinding.ActivityMainBinding
import com.example.genshinbook.presentaion.screen.main.MainScreen
import com.example.genshinbook.presentaion.ui.theme.GenshinBookTheme
import com.github.terrakok.cicerone.androidx.AppNavigator


class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.text.text = "SOmething my from Main activity"
        //todo put this setContent into fragment
//        setContent {
//            GenshinBookTheme {
//                // A surface container using the 'background' color from the theme
//                Scaffold(
//                    Modifier
//                        .fillMaxSize(),
//                ) {
//                    Navigator(screen = MainScreen())
//                }
//            }
//        }
    }


}
