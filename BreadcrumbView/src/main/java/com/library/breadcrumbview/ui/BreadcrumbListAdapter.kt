package com.library.breadcrumbview.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.library.breadcrumbview.R
import com.library.breadcrumbview.base.BaseRecyclerViewAdapter
import com.library.breadcrumbview.base.BaseViewHolder


class BreadcrumbListAdapter(
    private val list: MutableList<Breadcrumb>,
    private val listener: BreadcrumbItemClickListener
) : BaseRecyclerViewAdapter<Breadcrumb>(list, listener) {

    private lateinit var context: Context

    companion object {
        private const val TYPE_HEAD = 0
        private const val TYPE_BODY = 1
        private const val TYPE_TAIL = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Breadcrumb> {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_HEAD -> {
                BreadcrumbHeadViewHolder(inflater, parent)
            }
            TYPE_BODY -> {
                BreadcrumbBodyViewHolder(inflater, parent)
            }
            TYPE_TAIL -> {
                BreadcrumbTailViewHolder(inflater, parent)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val breadcrumb = items[position]
        return when (breadcrumb.breadCrumbType) {
            ItemType.HEAD -> TYPE_HEAD
            ItemType.TAIL -> TYPE_TAIL
            else -> TYPE_BODY
        }
    }

    override fun getItemCount(): Int = list.size

    inner class BreadcrumbHeadViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        BaseViewHolder<Breadcrumb>(inflater.inflate(R.layout.head_breadcrumb_item, parent, false)) {
        private var imageView: ImageView? = null

        init {
            imageView = itemView.findViewById(R.id.headImage)
        }

        override fun onBind(item: Breadcrumb) {
            imageView?.setBackgroundResource(R.drawable.ic_baseline_home_24)
            listener.onItemClick(item)
        }
    }

    inner class BreadcrumbBodyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        BaseViewHolder<Breadcrumb>(inflater.inflate(R.layout.body_breadcrumb_item, parent, false)) {
        private var titleView: TextView? = null
        private var rootLayout:ConstraintLayout?=null

        init {
            titleView = itemView.findViewById(R.id.titleView)
            rootLayout=itemView.findViewById(R.id.root)
        }

        override fun onBind(item: Breadcrumb) {
            changeBackground(titleView,rootLayout, item)
        }
    }

    inner class BreadcrumbTailViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        BaseViewHolder<Breadcrumb>(inflater.inflate(R.layout.tail_breadcrumb_item, parent, false)) {
        private var titleView: TextView? = null
        private var rootLayout:ConstraintLayout?=null

        init {
            titleView = itemView.findViewById(R.id.titleView)
            rootLayout=itemView.findViewById(R.id.root)
        }

        override fun onBind(item: Breadcrumb) {
            changeBackground(titleView, rootLayout,item)
        }
    }

    private fun changeBackground(textView: TextView?,constraintLayout: ConstraintLayout?, item: Breadcrumb) {
        textView?.text = item.title
        constraintLayout?.setBackgroundResource(item.backGroundImage)
        listener.onItemClick(item)
    }

}