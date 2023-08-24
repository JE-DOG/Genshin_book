package com.example.core.app.ui.compose.elements.base

import androidx.compose.material.MaterialTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.app.R
import com.example.core.ext.isNull
import com.example.core.app.ui.compose.theme.AlertShape

@Composable
fun GenshineBookAlertDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    text: String? = null,
    title: String? = null,
    confirmButText: String? = null,
    dismissButText: String? = null,
) {

    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        shape = AlertShape,
        containerColor = MaterialTheme.colors.primary,
        confirmButton = {
            GenshineBookButton(onClick = { onConfirm() }) {
                ButtonText(text =
                if (confirmButText.isNull())
                    stringResource(id = R.string.alert_confirm_but)
                else
                    confirmButText!!
                )
            }
        },
        dismissButton = {
            GenshineBookOutlinedButton(onClick = { onDismiss() }) {
                ButtonText(text =
                if (dismissButText.isNull())
                    stringResource(id = R.string.alert_dismiss_but)
                else
                    dismissButText!!
                )
            }
        },
        title = {
            Header1Text(
                text =
                if (title.isNull())
                    stringResource(id = R.string.alert_error_internet_title)
                else
                    title!!
            )
        },
        text = {
            Body1Text(
                text =
                if (text.isNull())
                    stringResource(id = R.string.alert_error_internet_text)
                else
                    text!!
            )
        }
    )

}


@Composable
@Preview
fun Some() {

    Text("Something")

}