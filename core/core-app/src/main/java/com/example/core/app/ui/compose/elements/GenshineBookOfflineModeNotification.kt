package com.example.core.app.ui.compose.elements

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.core.app.R
import com.example.core.app.ui.compose.elements.base.ButtonText
import com.example.core.app.ui.compose.elements.base.Header1Text

@Composable
fun GenshineBookOfflineModeNotification(
    onRepeat: () -> Unit
) {

    Header1Text(
        text = stringResource(id = R.string.offline),
        color = Color.White
    )
    Button(onClick = onRepeat) {
        ButtonText(text = stringResource(id = R.string.error_repeat))
    }

}