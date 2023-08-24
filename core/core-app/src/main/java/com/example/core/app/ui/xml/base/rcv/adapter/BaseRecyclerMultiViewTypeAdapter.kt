package com.example.core.app.ui.xml.base.rcv.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.core.app.ui.xml.base.rcv.RecyclerItem
import com.example.core.app.ui.xml.base.rcv.ViewType
import com.example.core.app.ui.xml.base.rcv.holder.BaseRecyclerHolder
import com.example.core.ext.isNotNull
import com.example.core.ext.isNull

abstract class BaseRecyclerMultiViewTypeAdapter: RecyclerView.Adapter<BaseRecyclerHolder<ViewBinding>?>() {

    /**
     * Mutable list with instance which have interface RecyclerItem
     * @see RecyclerItem
     */
    abstract var items: MutableList<RecyclerItem>

    /**
     * Function for get view type by item
     *
     * @param  item  This is simple item in the list for recycler which have interface RecyclerItem
     * @return ViewType
     * @see RecyclerItem
     * @see ViewType
     */
    abstract fun getViewType(item: RecyclerItem): ViewType<ViewBinding, RecyclerItem>

    override fun getItemCount() = items.size

    private var currentViewType: ViewType<ViewBinding, RecyclerItem>? = null

    /**
     * For get item position in the onCreateViewHolder
     *
     * Plan:
     *
     * 1.set currentViewType by implementation function "getViewType" in the adapter
     *
     * 2.Create ViewHolder by function create
     *
     * @param viewType This is item position
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseRecyclerHolder<ViewBinding> {

        currentViewType = getViewType(items[viewType])

        currentViewType!!.createViewHolder(parent, false)

        return currentViewType!!.viewHolder
    }

    /**
     * For get item position in the onCreateViewHolder
     *
     * Plan:
     *
     * Bind view holder by implementation function "onBindViewHolder"(when we are call bindViewHolder he is call onBindViewHolder) inside ViewType
     *
     * @param viewType This is item position
     */
    override fun onBindViewHolder(holder: BaseRecyclerHolder<ViewBinding>, position: Int) {
        currentViewType!!.bindViewHolder()
    }

    /**
     * For get item position in the onCreateViewHolder
     */
    override fun getItemViewType(position: Int) = position

}