package com.example.core.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.R
import com.example.core.ext.isNotNull

@Composable
fun MyError(
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
        Text(
            text = if (text.isNotNull()) text!! else stringResource(id = R.string.alert_error),
            fontSize = 20.sp
        )

        Button(onClick = onRepeat) {
            Text(text = if (repeatButText.isNotNull()) repeatButText!! else stringResource(id = R.string.error_repeat) )
        }
    }

}