package com.example.core.app.base.rcv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerAdapter<VB: ViewBinding,RI: RecyclerItem>(
    private val viewBindingInflater: (
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) -> VB
): RecyclerView.Adapter<BaseRecyclerHolder<VB>>() {

    private var _binding: VB? = null
    val binding
        get() = _binding!!

    abstract var items: MutableList<RI>



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerHolder<VB> {
        val inflater = LayoutInflater.from(parent.context)
        _binding = viewBindingInflater(
            inflater,
            parent,
            false
        )

        return BaseRecyclerHolder(binding).apply {
            onCreate()
        }
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