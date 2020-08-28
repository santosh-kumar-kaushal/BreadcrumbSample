package com.library.breadcrumbview.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.library.breadcrumbview.R

class BreadcrumbView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), BreadcrumbItemClickListener,IBreadcrumb
{

    private var breadcrumbView: RecyclerView

    private var listData = mutableListOf<Breadcrumb>()

    private var adapter: BreadcrumbListAdapter

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.view_custom_component, this, true)
        breadcrumbView = findViewById(R.id.breadcrumb)
        adapter = BreadcrumbListAdapter(listData, this)
        breadcrumbView.adapter = adapter
    }

    override fun addHomeIcon(homeIcon:Int)
    {
        val breadcrumb=Breadcrumb(
            ItemType.HEAD,
            "Item",
            ContextCompat.getColor(context, R.color.black))
        breadcrumb.homeIcon=homeIcon
        listData.add(breadcrumb)
    }

    override fun addItem(breadcrumb: Breadcrumb) {
        listData.add(breadcrumb)
        adapter.notifyDataSetChanged()
    }

    override fun removeCurrentItem() {
        with(listData)
        {
            if (this.size > 1) {
                this.removeAt(this.size - 1)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onItemClick(item: Breadcrumb) {

    }


}