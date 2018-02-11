package com.zcl.mainapp.plugs;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <pre>
 *     author : zhangchuanliang
 *     wx     : 644924861
 *     time   : 2018/02/10
 *     desc   :
 * </pre>
 */


//被启动的activity，，，，尽量用Activity，，不支持v7的AppCompatActivity

public class TargetActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.BLUE);

        TextView textView = new TextView(this);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(100, 100));
        textView.setText("started me not do manifest");
        textView.setTextColor(Color.BLACK);

        textView.setBackgroundColor(Color.BLUE);

//        myLayout.addView(textView);
        setContentView(textView);
    }



}
