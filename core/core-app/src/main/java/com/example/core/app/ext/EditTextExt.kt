package com.example.core.app.ext

import android.widget.EditText

val EditText.stringText
    get() = this.text.toString()