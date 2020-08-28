package com.library.breadcrumbview.ui

interface IBreadcrumb {

    fun addHomeIcon(homeIcon:Int)

    fun addItem(breadcrumb: Breadcrumb)

    fun removeCurrentItem()

}