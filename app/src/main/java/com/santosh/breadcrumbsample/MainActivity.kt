package com.santosh.breadcrumbsample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.library.breadcrumbview.ui.Breadcrumb
import com.library.breadcrumbview.ui.BreadcrumbView
import com.library.breadcrumbview.ui.ItemType

class MainActivity :AppCompatActivity()
{
    private lateinit var breadcrumbView: BreadcrumbView

    private lateinit var addButton: Button

    private lateinit var removeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        breadcrumbView=findViewById(R.id.breadcrumbView)
        addButton = findViewById(R.id.addButton)
        removeButton = findViewById(R.id.removeButton)
        breadcrumbView.addHomeIcon(R.drawable.ic_baseline_home_24)
        addButton.setOnClickListener {
            val breadcrumb=Breadcrumb(
                ItemType.BODY,
                "Item",
                ContextCompat.getColor(this, R.color.black)
            )
            breadcrumbView.addItem(breadcrumb)

        }
        removeButton.setOnClickListener {
            breadcrumbView.removeCurrentItem()
        }
    }
}