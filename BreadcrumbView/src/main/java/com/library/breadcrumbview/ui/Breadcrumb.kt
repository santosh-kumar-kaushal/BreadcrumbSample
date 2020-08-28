package com.library.breadcrumbview.ui

import com.library.breadcrumbview.R

data class Breadcrumb(
    var breadCrumbType: ItemType=ItemType.BODY,
    var title: String,
    var textColor: Int,
    var backGroundImage: Int= R.color.white
)
{
    var homeIcon:Int = R.drawable.ic_baseline_home_24

}