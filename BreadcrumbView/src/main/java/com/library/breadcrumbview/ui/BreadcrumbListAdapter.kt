package com.library.breadcrumbview.ui

import android.content.Context
import android.graphics.Typeface
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
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val breadcrumb = items[position]
        return when (breadcrumb.breadCrumbType) {
            ItemType.BODY -> TYPE_BODY
            else -> TYPE_HEAD
        }
    }

    override fun getItemCount(): Int = list.size

    inner class BreadcrumbHeadViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        BaseViewHolder<Breadcrumb>(inflater.inflate(R.layout.head_breadcrumb_item, parent, false)) {
        private var imageView: ImageView = itemView.findViewById(R.id.headImage)
        private var constraintLayout: ConstraintLayout = itemView.findViewById(R.id.root)

        override fun onBind(item: Breadcrumb) {
            imageView.setBackgroundResource(item.homeDrawable)
            constraintLayout.setOnClickListener {
                listener.onItemClick(item)
            }

        }
    }

    inner class BreadcrumbBodyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        BaseViewHolder<Breadcrumb>(inflater.inflate(R.layout.body_breadcrumb_item, parent, false)) {
        private var titleView: TextView = itemView.findViewById(R.id.titleView)
        private var constraintLayout: ConstraintLayout = itemView.findViewById(R.id.root)
        private var separatorView: ImageView = itemView.findViewById(R.id.separator)

        override fun onBind(item: Breadcrumb) {
            with(titleView)
            {
                text = item.ItemTitle
                setTextColor(item.textColor)
                textSize = item.textSize.toFloat()
                when (item.textStyle) {
                    TextStyle.BOLD_ITALIC -> setTypeface(typeface, Typeface.BOLD_ITALIC)
                    TextStyle.BOLD -> setTypeface(typeface, Typeface.BOLD)
                    TextStyle.ITALIC -> setTypeface(typeface, Typeface.ITALIC)
                    TextStyle.NORMAL -> setTypeface(typeface, Typeface.NORMAL)
                }

            }
            separatorView.setBackgroundResource(item.separatorDrawable)
            constraintLayout.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }
}