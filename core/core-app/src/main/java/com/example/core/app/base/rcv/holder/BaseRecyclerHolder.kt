package com.example.core.app.base.rcv.holder

import android.content.Context
import android.content.res.Resources
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BaseRecyclerHolder<VB: ViewBinding>(
    val binding: VB
): RecyclerView.ViewHolder(binding.root) {

    val context: Context get() = binding.root.context

    val resource: Resources get() = context.resources
}