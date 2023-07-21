package com.example.core.elements

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.core.R

@Composable
fun OfflineModeNotification(
    onRepeat: () -> Unit
) {

    Text(
        text = stringResource(id = R.string.offline),
        color = Color.White
    )
    Button(onClick = onRepeat) {
        Text(text = stringResource(id = R.string.error_repeat))
    }

}