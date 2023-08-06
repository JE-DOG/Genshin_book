package com.example.feature.add.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import coil.load
import com.example.core.app.base.rcv.BaseRecyclerAdapter
import com.example.core.app.base.rcv.BaseRecyclerHolder
import com.example.feature.add.chat.R
import com.example.feature.add.chat.databinding.ListItemFindUserBinding
import com.example.feature.add.chat.model.Profile

class FindUsersAdapter(
    private val onItemClickListener: (userId: String) -> Unit
): BaseRecyclerAdapter<ListItemFindUserBinding,Profile>(
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
            placeholder(com.example.core.R.drawable.ic_default_user_avatar)
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