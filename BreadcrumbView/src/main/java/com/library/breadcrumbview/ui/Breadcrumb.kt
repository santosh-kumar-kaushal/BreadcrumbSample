package com.library.breadcrumbview.ui

import com.library.breadcrumbview.R

open class Breadcrumb(
     var breadCrumbType: ItemType = ItemType.BODY,
     var ItemTitle: String
) {
    var homeDrawable: Int = R.drawable.breadcrumb_default_home_icon
    open var textColor: Int = R.color.bread_crumb_color
    open var textSize: Int = R.dimen.text_size
    open var textStyle: TextStyle = TextStyle.BOLD_ITALIC
    open var separatorDrawable: Int = R.drawable.breadcrumb_default_body_separator
}