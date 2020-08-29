package com.library.breadcrumbview.ui

interface IBreadcrumb {

    fun addHomeDrawable(drawable:Int)

    fun addItem(breadcrumb: Breadcrumb)

    fun removeItem()

    fun setItemOnClickListener(listener: BreadcrumbItemClickListener?)

}