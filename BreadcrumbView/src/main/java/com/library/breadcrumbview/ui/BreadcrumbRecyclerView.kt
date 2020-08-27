package com.library.breadcrumbview.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.library.breadcrumbview.R

class BreadcrumbRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr)
{
    init {
        LayoutInflater.from(context)
            .inflate(R.layout.view_custom_component, this, true)
    }

}