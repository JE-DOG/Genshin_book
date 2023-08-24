package com.example.feature.main.empty

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.core.app.ui.compose.elements.base.Body1Text

@Composable
fun EmptyScreen(text: String = "Nothing") {

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Body1Text(text = text)
    }

}