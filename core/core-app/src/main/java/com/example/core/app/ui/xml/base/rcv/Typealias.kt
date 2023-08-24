package com.example.core.app.ui.xml.base.rcv

import androidx.viewbinding.ViewBinding
import android.view.LayoutInflater
import android.view.ViewGroup

typealias Binder = (ViewBinding) -> Unit

typealias Inflater<VB> = (
    inflater: LayoutInflater,
    parent: ViewGroup,
    attachToParent: Boolean
) -> VB