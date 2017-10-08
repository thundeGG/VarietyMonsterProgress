<img src = "/screens/croller_cover.png"><br>
[![Platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Release](https://jitpack.io/v/7hundeR/VarietyMonsterProgress.svg)](https://jitpack.io/#7hundeR/VarietyMonsterProgress)

# Usage
1) In your root build.gradle:
```
allprojects {
repositories {
    jcenter()
    maven { url "https://jitpack.io"; }
}
}
```
2) In your library/build.gradle add:
```
compile 'com.github.7hundeR:VarietyMonsterProgress:v1.0'
```


### XML
```xml
<com.thunder.varietymonsterprogress.VarietyMonsterProgress
        android:layout_width="300dp"
        android:layout_height="80dp"
        android:layout_marginTop="10dp"
        app:count="10"
        app:normalColor="@color/c_bdbdbd"
        app:radius="100"
        app:selected="7"
        app:selectedColor="@color/c_00A5FE"/>
```

### Java
```java
VarietyMonsterProgress mProgress = (VarietyMonsterProgress) findViewById(R.id.progress);
        mProgress.setCount(6);
        mProgress.setSelected(2);
        mProgress.setRadius(50);
        mProgress.setSelectedColor(getResources().getColor(R.color.c_00A5FE));
        mProgress.setNormalColor(getResources().getColor(R.color.c_bdbdbd));
        mProgress.setSpacing(20);
```

# Attributes

<img src = "/screens/croller_attributes.png"><br>

XML Attribute | Java set method | Functionality
------------ | ------------- | -------------
count | setCount(int count) | Set the total number of the VarietyMonsterProgress
selected | setSelected(int selected) | Set the current progress of the VarietyMonsterProgress
spacing | setSpacing(float spacing) | Set the spacing between each
radius | setRadius(float radius) | Set each fillet
selectedColor | setSelectedColor(int selectedColor) | Sets the selected color
normalColor | setNormalColor(int normalColor) | Sets the default color

# Examples
<img src = "https://github.com/7hundeR/VarietyMonsterProgress/blob/master/screenshot.png">
