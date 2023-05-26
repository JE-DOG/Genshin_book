package com.example.genshinbook.core.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingContent(
    isLoading: Boolean,
    isError: Boolean,
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {},
    content: @Composable () -> Unit,
) {

    if (isError){

        MyAlertDialog(
            onDismiss = onDismiss,
            onConfirm = onConfirm
        )

    }

    if(isLoading){

        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }

    }else{
        content()
    }

}