package com.example.feature.chats.list.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.feature.chats.list.model.Chat

class ChatsListDiffCallback(
    private val oldList: List<Chat>,
    private val newList: List<Chat>,
): DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].lastMessage == newList[newItemPosition].lastMessage

}