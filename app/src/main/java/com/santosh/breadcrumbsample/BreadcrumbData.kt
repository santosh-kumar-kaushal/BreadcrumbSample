package com.santosh.breadcrumbsample

import com.library.breadcrumbview.ui.Breadcrumb
import com.library.breadcrumbview.ui.ItemType
import com.library.breadcrumbview.ui.TextStyle

data class BreadcrumbData(var breadCrumb: ItemType = ItemType.BODY,
                          var title: String):Breadcrumb(breadCrumb,title)
{
    override var textColor: Int=R.color.bread_crumb_color

    override var textSize: Int=15

    override var separatorDrawable: Int=R.drawable.breadcrumb_body_separator

    override var textStyle: TextStyle = TextStyle.BOLD_ITALIC

}

