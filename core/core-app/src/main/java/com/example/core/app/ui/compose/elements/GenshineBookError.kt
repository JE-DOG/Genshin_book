package com.example.core.app.ui.compose.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core.app.R
import com.example.core.app.ui.compose.elements.base.ButtonText
import com.example.core.app.ui.compose.elements.base.Header1Text
import com.example.core.ext.isNotNull

@Composable
fun GenshineBookError(
    text: String? = null,
    onRepeat: () -> Unit = {},
    repeatButText: String? = null
) {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(40.dp),
            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = "error icon"
        )
        Header1Text(
            text = if (text.isNotNull()) text!! else stringResource(id = R.string.alert_error)
        )

        Button(onClick = onRepeat) {
            ButtonText(
                text = if (repeatButText.isNotNull())
                    repeatButText!!
                else
                    stringResource(id = R.string.error_repeat) )
        }
    }

}