package com.example.genshinbook

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.genshinbook.presentaion.screen.TestScreen
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
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {

                    }
                }
            }
        }
    }
}
