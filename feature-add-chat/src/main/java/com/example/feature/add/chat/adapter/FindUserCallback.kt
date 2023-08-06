package com.example.feature.add.chat.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.feature.add.chat.model.Profile

class FindUserCallback(
    private val newList: List<Profile>,
    private val oldList: List<Profile>,
): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem.avatar == newItem.avatar || oldItem.fullName == newItem.fullName
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

}