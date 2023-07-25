package com.example.core.app.elements

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.R
import com.example.core.ext.isNull
import com.example.core.app.ui.theme.AlertBackground
import com.example.core.app.ui.theme.AlertShape

@Composable
fun MyAlertDialog(
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
        containerColor = AlertBackground,
        confirmButton = {
            Button(onClick = { onConfirm() }) {
                Text(text =
                if (confirmButText.isNull())
                    stringResource(id = R.string.alert_confirm_but)
                else
                    confirmButText!!
                )
            }
        },
        dismissButton = {
            OutlinedButton(onClick = { onDismiss() }) {
                Text(text =
                if (dismissButText.isNull())
                    stringResource(id = R.string.alert_dismiss_but)
                else
                    dismissButText!!
                )
            }
        },
        title = {
            Text(
                text =
                if (title.isNull())
                    stringResource(id = R.string.alert_error_internet_title)
                else
                    title!!
            )
        },
        text = {
            Text(
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