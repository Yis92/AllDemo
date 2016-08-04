package com.sunny.vm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sunny.R;
import com.sunny.base.BaseActivity;

/**
 * Created by toreal on 2016/7/25.
 */
public class DemoActivity extends BaseActivity {

    private LinearLayout llMain;
    private TextView btnDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_demo);
    }

    @Override
    public void initBoot() {

    }

    @Override
    public void initViews() {
        llMain = findView(R.id.ll_main);
        btnDemo = findView(R.id.btn_demo);
    }

    @Override
    public void initData(Intent intent) {

    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        showToast("x:"+event.getX()+"y:"+event.getY());
//        return false;
//    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        showToast("x:"+event.getX()+"y:"+event.getY());
//        return super.onTouchEvent(event);
//    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        showToast("x:"+ev.getX()+"y:"+ev.getY());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void initEvents() {

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("qqq","dianji.....");
            }
        });

//        llMain.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                showToast("x:"+event.getX()+"y:"+event.getY());
//                return false;
//            }
//        });
    }

    @Override
    public Class<?> getClazz() {
        return DemoActivity.class;
    }
}
