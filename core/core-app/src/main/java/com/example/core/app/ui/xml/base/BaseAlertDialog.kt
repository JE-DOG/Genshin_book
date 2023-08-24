package com.example.core.app.ui.xml.base

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.core.app.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class BaseAlertDialog(
    private val onPositiveButtonClickListener: () -> Unit = {},
    private val onNegativeButtonClickListener: () -> Unit = {},
    private val hasOneAction: Boolean = false,
    private val message: String? = null,
    private val title: String? = null
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = MaterialAlertDialogBuilder(it)
            builder
                .setTitle(title ?: resources.getString(R.string.alert_error_internet_title))
                .setMessage(message ?: resources.getString(R.string.alert_error_internet_text))
                .setPositiveButton(R.string.alert_confirm_but){ dialog,_ ->
                    onPositiveButtonClickListener()
                    dialog.cancel()
                }
            if (!hasOneAction){
                builder.setNegativeButton(R.string.alert_dismiss_but){ dialog,_ ->
                    onNegativeButtonClickListener()
                    dialog.cancel()
                }
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}
