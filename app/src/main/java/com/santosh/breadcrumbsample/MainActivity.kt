package com.santosh.breadcrumbsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.library.breadcrumbview.ui.Breadcrumb
import com.library.breadcrumbview.ui.BreadcrumbItemClickListener
import com.library.breadcrumbview.ui.BreadcrumbListAdapter
import com.library.breadcrumbview.ui.ItemType

class MainActivity : AppCompatActivity(), BreadcrumbItemClickListener {


    private lateinit var breadcrumbView: RecyclerView

    private lateinit var addButton: Button

    private lateinit var removeButton: Button

    private lateinit var adapter: BreadcrumbListAdapter

    private var listData = mutableListOf<Breadcrumb>()

    private var counter = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        breadcrumbView = findViewById(R.id.breadcrumb)
        addButton = findViewById(R.id.addButton)
        removeButton = findViewById(R.id.removeButton)
        preparedBreadcrumbData()
        adapter = BreadcrumbListAdapter(listData, this)
        breadcrumbView.adapter = adapter
        addButton.setOnClickListener {
            addItem()
            adapter.notifyDataSetChanged()
            breadcrumbView.scrollToPosition(listData.size - 1)
            counter++
        }
        removeButton.setOnClickListener {
            removeItem()
            adapter.notifyDataSetChanged()
        }
    }

    override fun onItemClick(item: Breadcrumb) {
        // Handle item click of bread crumb.
    }

    private fun addItem(): MutableList<Breadcrumb> {
        listData.add(
            Breadcrumb(
                ItemType.BODY,
                "Item $counter",
                ContextCompat.getColor(this, R.color.black)
            )
        )
        return listData
    }

    private fun removeItem() {
        if (listData.size > 1) {
            listData.removeAt(listData.size - 1)
        }
    }

    private fun preparedBreadcrumbData(): MutableList<Breadcrumb> {
        listData.add(
            Breadcrumb(
                ItemType.HEAD,
                "Item",
                ContextCompat.getColor(this, R.color.black)
            )
        )
        for (i in 1..3) {
            listData.add(
                Breadcrumb(
                    ItemType.BODY,
                    "Item $i",
                    ContextCompat.getColor(this, R.color.black)
                )
            )
        }
        return listData
    }
}