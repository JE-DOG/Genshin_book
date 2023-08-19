package com.example.core.app.base.rcv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.core.app.base.rcv.holder.BaseRecyclerHolder

abstract class ViewType<VB: ViewBinding,RI: RecyclerItem>(
    val inflater: Inflater<VB>
){

    protected abstract val item: RI

    private var _viewHolder: BaseRecyclerHolder<VB>? = null

    val viewHolder
        get() = _viewHolder!!

    protected abstract fun onBindViewHolder(binding: VB)

    open fun bindViewHolder(){
        onBindViewHolder(viewHolder.binding)
    }

    fun createViewHolder(
        parent: ViewGroup,
        attachToParent: Boolean
    ){
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = inflater(inflater, parent, attachToParent)

        _viewHolder = BaseRecyclerHolder(binding)
    }

}