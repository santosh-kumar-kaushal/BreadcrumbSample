package com.library.breadcrumbview.ui

import com.library.breadcrumbview.R

data class Breadcrumb(
    var breadCrumbType: ItemType,
    var title: String,
    var textColor: Int,
    var backGroundImage: Int= R.color.white
)