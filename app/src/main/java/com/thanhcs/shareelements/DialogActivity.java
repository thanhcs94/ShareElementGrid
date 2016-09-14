package com.thanhcs.shareelements;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


public class DialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Intent i  = getIntent();
        Mobject mobject = (Mobject) i.getSerializableExtra("data");
        SquareImageLayout img = (SquareImageLayout) findViewById(R.id.image);
        img.setImageResource(mobject.getResource());
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
       // findViewById(R.id.rela).setOnClickListener(null);
    }
}
