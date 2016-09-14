package com.thanhcs.shareelements;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        List<Mobject> listObject =  new ArrayList<>();
        listObject.add(new Mobject("Faster Thinking", "250000","com.thanhcs.fasterthinking", R.mipmap.ic1));
        listObject.add(new Mobject("Motivation Story", "190000","com.thanhcs.motivationstories", R.mipmap.ic2));
        listObject.add(new Mobject("FunStack", "250000","com.funstack", R.mipmap.ic3));
        listObject.add(new Mobject("Ask2Know Everything", "1000","com.thanhcs.ask2know", R.mipmap.ic4));
        listObject.add(new Mobject("Mp3Cutter", "500","thanhcs.com.mp3cutter", R.mipmap.ic5));
        listObject.add(new Mobject("Faster Thinking", "250000","com.thanhcs.fasterthinking", R.mipmap.ic1));
        listObject.add(new Mobject("Motivation Story", "190000","com.thanhcs.motivationstories", R.mipmap.ic2));
        listObject.add(new Mobject("FunStack", "250000","com.funstack", R.mipmap.ic3));
        listObject.add(new Mobject("Ask2Know Everything", "1000","com.thanhcs.ask2know", R.mipmap.ic4));
        listObject.add(new Mobject("Mp3Cutter", "500","thanhcs.com.mp3cutter", R.mipmap.ic5));

        gridView.setAdapter(new GridViewAdapter(this, listObject));
    }
}
