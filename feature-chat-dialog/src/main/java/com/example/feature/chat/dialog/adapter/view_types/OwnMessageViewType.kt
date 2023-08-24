package com.example.feature.chat.dialog.adapter.view_types

import com.example.core.app.ui.xml.base.rcv.ViewType
import com.example.feature.chat.dialog.databinding.ListItemOwnMessageBinding
import com.example.feature.chat.dialog.model.Message

class OwnMessageViewType(
    override val item: Message
): ViewType<ListItemOwnMessageBinding, Message>(ListItemOwnMessageBinding::inflate) {

    override fun onBindViewHolder(binding: ListItemOwnMessageBinding) = with(binding){

        messageText.text = item.message

    }

}