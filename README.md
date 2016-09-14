# ShareElementGrid
![alt tag](https://media.giphy.com/media/awAhvkDLfL2HS/giphy.gif)

#Res/transition/image_transform.xml<br/>
```
<?xml version="1.0" encoding="utf-8"?>
<transitionSet xmlns:android="http://schemas.android.com/apk/res/android">
    <changeImageTransform/>
    <changeBounds
        android:interpolator="@android:interpolator/accelerate_decelerate"
        android:duration="400"/>
</transitionSet>
```

#Style.xml
```
<!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <!-- enable window content transitions -->
        <item name="android:windowContentTransitions">true</item>

        <!-- specify shared element transitions -->
        <item name="android:windowSharedElementEnterTransition">
            @transition/change_image_transform</item>
        <item name="android:windowSharedElementExitTransition">
            @transition/change_image_transform</item>
    </style>

    <style name="AppTheme.Transparent" parent="AppTheme">
        <item name="android:windowIsTranslucent">true</item>
        <item name="android:windowBackground">@android:color/transparent</item>
        <item name="android:windowContentOverlay">@null</item>
        <item name="android:windowNoTitle">true</item>
        <item name="android:backgroundDimEnabled">true</item>
    </style>
    
```

#in your image,2side xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="1.5dp"
    android:transitionName="background_transition">

    <com.thanhcs.shareelements.SquareImageLayout
        android:id="@+id/image"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:transitionName="image_transition"
        android:src="@android:drawable/btn_star_big_on"/>

</LinearLayout>
```

#when you do the intent 
```
v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(mContext, DialogActivity.class));
                i.putExtra("data", listObject.get(position));
                ActivityOptions options = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions
                            .makeSceneTransitionAnimation((Activity) mContext,
                                    Pair.create(v, "background_transition"),
                                    Pair.create(v.findViewById(R.id.image), "image_transition"));
                    mContext.startActivity(i, options.toBundle());
                }else
                    mContext.startActivity(i);
            }
        });
```

#when back from new activity
```
((View)findViewById(R.id.rela).getParent()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }else{
                    finish();
                }
            }
        });
```


