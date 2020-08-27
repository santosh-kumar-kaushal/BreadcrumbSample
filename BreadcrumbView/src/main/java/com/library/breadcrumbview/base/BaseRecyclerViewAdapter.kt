package com.library.breadcrumbview.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T>(val items: MutableList<T>, val itemListener: BaseItemListener<T>) :
    RecyclerView.Adapter<BaseViewHolder<T>>() {

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.onBind(items[position])
    }

    fun addItems(items: List<T>?) {
        items?.let { this.items.addAll(it) }
        notifyDataSetChanged()
    }

    fun clearItems() {
        items.clear()
    }

}