package com.example.core.app.elements.xml

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.core.R
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class BaseErrorAlertDialog(
    private val onPositiveButtonClickListener: () -> Unit = {},
    private val onNegativeButtonClickListener: () -> Unit = {},
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = MaterialAlertDialogBuilder(it)
            builder
                .setTitle(R.string.alert_error_internet_title)
                .setMessage(R.string.alert_error_internet_text)
                .setPositiveButton(R.string.alert_confirm_but){ dialog,_ ->
                    onPositiveButtonClickListener()
                    dialog.cancel()
                }
                .setNegativeButton(R.string.alert_dismiss_but){ dialog,_ ->
                    onNegativeButtonClickListener()
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}
