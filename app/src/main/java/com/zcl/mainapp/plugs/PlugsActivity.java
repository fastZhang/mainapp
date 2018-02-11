package com.zcl.mainapp.plugs;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;

import com.zcl.mainapp.R;


//站位Activity
public class PlugsActivity extends Activity {


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugs);

        findViewById(R.id.tv_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlugsActivity.this, TargetActivity.class));
            }
        });
    }



}
