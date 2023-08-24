package com.example.feature.add.chat.adapter

import androidx.recyclerview.widget.DiffUtil
import coil.load
import com.example.core.app.ui.xml.base.rcv.adapter.BaseRecyclerAdapter
import com.example.core.app.ui.xml.base.rcv.holder.BaseRecyclerHolder
import com.example.feature.add.chat.databinding.ListItemFindUserBinding
import com.example.feature.add.chat.model.Profile

class FindUsersAdapter(
    private val onItemClickListener: (userId: String) -> Unit
): BaseRecyclerAdapter<ListItemFindUserBinding, Profile>(
    viewBindingInflater = ListItemFindUserBinding::inflate
) {

    override var items: MutableList<Profile> = mutableListOf()
        set(value) {
            val callback = FindUserCallback(
                newList = value,
                oldList = field
            )
            field = value
            DiffUtil
                .calculateDiff(callback)
                .dispatchUpdatesTo(this)
        }

    override fun BaseRecyclerHolder<ListItemFindUserBinding>.onBind(item: Profile): Unit = with(binding) {

        userAvatarImg.load(item.avatar) {
            placeholder(com.example.core.app.R.drawable.ic_profile)
        }

        userFullnameTv.apply {

            text = item.fullName

        }

        root.apply {

            setOnClickListener {
                onItemClickListener(item.id)
            }

        }

    }


}