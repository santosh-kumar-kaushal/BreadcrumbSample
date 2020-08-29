package com.library.breadcrumbview.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.library.breadcrumbview.R

class BreadcrumbView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), BreadcrumbItemClickListener,IBreadcrumb
{

    private var breadcrumbView: RecyclerView

    private var listData = mutableListOf<Breadcrumb>()

    private var adapter: BreadcrumbListAdapter

    private  var listener:BreadcrumbItemClickListener?=null

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.view_custom_component, this, true)
        breadcrumbView = findViewById(R.id.breadcrumb)
        adapter = BreadcrumbListAdapter(listData, this)
        breadcrumbView.adapter = adapter
    }

    override fun addHomeDrawable(drawable:Int)
    {
        val breadcrumb=Breadcrumb(
            ItemType.HEAD,
            "Home")
        breadcrumb.homeDrawable=drawable
        listData.add(breadcrumb)
    }

    override fun addItem(breadcrumb: Breadcrumb) {
        listData.add(breadcrumb)
        breadcrumbView.scrollToPosition(listData.size - 1)
        adapter.notifyDataSetChanged()
    }

    override fun removeItem() {
        with(listData)
        {
            if (this.size > 1) {
                this.removeAt(this.size - 1)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun setItemOnClickListener(listener: BreadcrumbItemClickListener?) {
        this.listener=listener
    }

    override fun onItemClick(item: Breadcrumb) {
         listener?.onItemClick(item)
    }


}