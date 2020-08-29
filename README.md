# BreadcrumbSample

- Breadcrumbview for navigation.
- Ready to use library.

# Screenshots

![Screen Recording 2020-08-29 at 3 22 30 PM](https://user-images.githubusercontent.com/43371182/91634170-f25de100-ea0b-11ea-821d-d749de58079e.gif)

# Overview of BreadcrumbView library

- Add Item
- Remove Item
- Change home drawable
- Change separator drawable
- Change text color
- Change text size
- Change text style


## Using BreadcrumbView Library in your Android application

#### Add this in your build.gradle - Project level

```allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

#### Add this in your build.gradle - App level

``` 
implementation 'com.github.santosh-kumar-kaushal:BreadcrumbSample:1.0'

```

#### Add BreadcrumbView to layout file

``` <com.library.breadcrumbview.ui.BreadcrumbView
        android:id="@+id/breadcrumbView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"/>
 ```
        

#### Then initialize it in onCreate() Method of view class

```private lateinit var breadcrumbView: BreadcrumbView

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        breadcrumbView=findViewById(R.id.breadcrumbView)
        breadcrumbView.addHomeDrawable(R.drawable.breadcrumb_home_icon)
        }
```

#### Then call methods to add and remove item.

 ```
    breadcrumbView.addItem(breadcrumb)
    breadcrumbView.removeItem()
 ```

#### Want to change the text color, text size, separator drawable.

###### Create your own model and extend Breadcrumb and override felids you want to customize.

```
data class BreadcrumbData(var breadCrumb: ItemType = ItemType.BODY,
                          var title: String):Breadcrumb(breadCrumb,title)
{
    override var textColor: Int=R.color.bread_crumb_color

    override var textSize: Int=15

    override var separatorDrawable: Int=R.drawable.breadcrumb_body_separator

    override var textStyle: TextStyle = TextStyle.BOLD_ITALIC

}
```

# License

```
   Copyright (C) 2020 Santosh Kumar

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
  ```

        


