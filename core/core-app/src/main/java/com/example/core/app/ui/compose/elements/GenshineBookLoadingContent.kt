package com.example.core.app.ui.compose.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.core.app.ui.compose.elements.base.GenshineBookAlertDialog
import com.example.core.app.ui.compose.elements.base.GenshineBookProgressBar

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GenshineBookLoadingContent(
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
            GenshineBookProgressBar()
        }else if (isError) {

            GenshineBookAlertDialog(
                onDismiss = onDismiss,
                onConfirm = onConfirm
            )

        } else {
            content()
        }
    }
}