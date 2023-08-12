package com.example.feature.chat.dialog.adapter

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import com.example.core.app.base.rcv.RecyclerItem
import com.example.core.app.base.rcv.ViewType
import com.example.core.app.base.rcv.adapter.BaseRecyclerMultiViewTypeAdapter
import com.example.feature.chat.dialog.adapter.view_types.OtherMessageViewType
import com.example.feature.chat.dialog.adapter.view_types.OwnMessageViewType
import com.example.feature.chat.dialog.model.Message
import javax.inject.Inject

class DialogAdapter @Inject constructor(
    private val userId: String
): BaseRecyclerMultiViewTypeAdapter() {

    override var items: MutableList<RecyclerItem> = mutableListOf()
        set(value) {
            val callback = DialogAdapterCallback(
                oldList = field as MutableList<Message>,
                newList = value as MutableList<Message>
            )
            Log.d("UpdateTag","From recycler ->" + (value as MutableList<Message>).toString())
            field = value

            DiffUtil
                .calculateDiff(callback)
                .dispatchUpdatesTo(this)
            Log.d("UpdateTag","From recycler ->" + (items as MutableList<Message>).toString())

        }

    override fun getViewType(item: RecyclerItem): ViewType<ViewBinding, RecyclerItem> {
        val item = item as Message

        return if (item.userId == userId){
            OwnMessageViewType(item)
        }else {
            OtherMessageViewType(item)
        } as ViewType<ViewBinding, RecyclerItem>

    }

}