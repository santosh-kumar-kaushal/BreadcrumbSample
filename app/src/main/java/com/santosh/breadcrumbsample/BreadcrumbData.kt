package com.santosh.breadcrumbsample

import com.library.breadcrumbview.ui.Breadcrumb
import com.library.breadcrumbview.ui.ItemType
import com.library.breadcrumbview.ui.TextStyle

data class BreadcrumbData(var breadCrumb: ItemType = ItemType.BODY,
                          var title: String):Breadcrumb(breadCrumb,title)
{
    override var textColor: Int=R.color.material_on_background_disabled

    override var textSize: Int=16

    override var separatorDrawable: Int=R.drawable.breadcrumb_default_body_separator

    override var textStyle: TextStyle = TextStyle.ITALIC

}

