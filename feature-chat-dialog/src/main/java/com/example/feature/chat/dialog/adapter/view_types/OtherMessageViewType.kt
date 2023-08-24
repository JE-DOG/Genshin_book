package com.example.feature.chat.dialog.adapter.view_types

import com.example.core.app.ui.xml.base.rcv.ViewType
import com.example.feature.chat.dialog.databinding.ListItemOtherMessageBinding
import com.example.feature.chat.dialog.model.Message

class OtherMessageViewType(
    override val item: Message
): ViewType<ListItemOtherMessageBinding, Message>(ListItemOtherMessageBinding::inflate) {

    override fun onBindViewHolder(binding: ListItemOtherMessageBinding) = with(binding){

        messageText.text = item.message

    }
}