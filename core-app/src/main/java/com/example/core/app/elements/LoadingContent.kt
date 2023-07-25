package com.example.core.app.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoadingContent(
    isLoading: Boolean,
    isError: Boolean,
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Box(
        Modifier
            .wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        }else if (isError) {

            MyAlertDialog(
                onDismiss = onDismiss,
                onConfirm = onConfirm
            )

        } else {
            content()
        }
    }
}