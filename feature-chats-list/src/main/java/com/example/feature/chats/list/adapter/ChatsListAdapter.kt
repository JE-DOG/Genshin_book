package com.example.feature.chats.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import coil.load
import com.example.core.app.base.rcv.BaseRecyclerAdapter
import com.example.core.app.base.rcv.BaseRecyclerHolder
import com.example.core.R
import com.example.core.ext.isNotNull
import com.example.core.ext.isNull
import com.example.feature.chats.list.adapter.diff.ChatsListDiffCallback
import com.example.feature.chats.list.model.Chat
import com.example.feature_chats_list.databinding.ListItemChatBinding

class ChatsListAdapter: BaseRecyclerAdapter<ListItemChatBinding, Chat>() {

    override var items: MutableList<Chat> = mutableListOf()
        set(value) {
            val diffUtil = ChatsListDiffCallback(
                field,
                value
            )
            val diffResult = DiffUtil.calculateDiff(diffUtil)
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override val viewBindingInflater: (
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ) -> ListItemChatBinding = ListItemChatBinding::inflate

    override fun BaseRecyclerHolder<ListItemChatBinding>.onBind(item: Chat): Unit = with(binding){

        userAvatarImg.load(item.avatar) {
            placeholder(resource.getDrawable(R.drawable.ic_default_user_avatar))

        }
        if (item.lastMessage.isNotNull()){
            userLastMessageTv.text = item.lastMessage
        }else {
            userLastMessageTv.setTextColor(resource.getColor(com.example.feature_chats_list.R.color.list_item_chat_last_message_placeholder))
            userLastMessageTv.text = resource.getString(com.example.feature_chats_list.R.string.placeholder_last_message)
        }

        userFullnameTv.text = item.fullName

    }

}