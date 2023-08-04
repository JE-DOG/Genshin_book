package com.example.core.app.base.rcv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerAdapter<VB: ViewBinding,RI: RecyclerItem>: RecyclerView.Adapter<BaseRecyclerHolder<VB>>() {

    abstract var items: MutableList<RI>

    abstract val viewBindingInflater: (
                inflater: LayoutInflater,
                parent: ViewGroup,
                attachToParent: Boolean
            ) -> VB

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerHolder<VB> =
        BaseRecyclerHolder(viewBindingInflater(LayoutInflater.from(parent.context), parent, false)).apply {
            onCreate()
        }

    override fun onBindViewHolder(holder: BaseRecyclerHolder<VB>, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size

    open fun BaseRecyclerHolder<VB>.onCreate(){

    }

    open fun BaseRecyclerHolder<VB>.onBind(item: RI){

    }

}