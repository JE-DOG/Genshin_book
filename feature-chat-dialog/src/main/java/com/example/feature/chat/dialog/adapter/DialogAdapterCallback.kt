package com.example.feature.chat.dialog.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.feature.chat.dialog.model.Message

class DialogAdapterCallback(
    private val oldList: List<Message>,
    private val newList: List<Message>,
): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem.message == newItem.message
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

}