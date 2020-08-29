package com.santosh.breadcrumbsample

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.library.breadcrumbview.ui.Breadcrumb
import com.library.breadcrumbview.ui.BreadcrumbItemClickListener
import com.library.breadcrumbview.ui.BreadcrumbView
import com.library.breadcrumbview.ui.ItemType

class MainActivity :AppCompatActivity(), BreadcrumbItemClickListener
{
    private lateinit var breadcrumbView: BreadcrumbView

    private lateinit var addButton: Button

    private lateinit var removeButton: Button

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        breadcrumbView=findViewById(R.id.breadcrumbView)
        addButton = findViewById(R.id.addBodyButton)
        removeButton = findViewById(R.id.removeButton)
        breadcrumbView.setItemOnClickListener(this)

        //breadcrumb related operation.
        breadcrumbView.addHomeDrawable(R.drawable.breadcrumb_home_icon)

        addButton.setOnClickListener {
            val breadcrumb=BreadcrumbData(
                ItemType.BODY,
                "Item $counter"
            )
            //Add item to breadcrumb
            breadcrumbView.addItem(breadcrumb)
            counter++
        }

        removeButton.setOnClickListener {
            //Removes item from breadcrumb
            breadcrumbView.removeItem()
            if(counter!=0) {
                counter--
            }
        }
    }

    override fun onItemClick(item: Breadcrumb) {
            Toast.makeText(this,"clicked -> ${item.ItemTitle}",Toast.LENGTH_LONG).show()
    }
}