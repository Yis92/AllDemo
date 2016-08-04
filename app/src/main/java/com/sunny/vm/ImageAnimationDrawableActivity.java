package com.sunny.vm;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sunny.R;
import com.sunny.base.BaseActivity;

/**
 * 微信红包金币旋转动画效果
 * Created by liuyi on 2016/6/23.
 */
public class ImageAnimationDrawableActivity extends BaseActivity{

    private ImageView imageView;
    private LinearLayout llPopContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_image_animation);
    }

    @Override
    public void initBoot() {

    }

    @Override
    public void initViews() {
        imageView = findView(R.id.image);
        llPopContent = findView(R.id.ll_pop_content);
    }

    @Override
    public void initData(Intent intent) {
        llPopContent.getBackground().setAlpha(150);
    }

    @Override
    public void initEvents() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取AnimationDrawable对象
                AnimationDrawable animationDrawable = (AnimationDrawable)imageView.getBackground();

                // 动画是否正在运行
                if(animationDrawable.isRunning()){
                    //停止动画播放
                    animationDrawable.stop();
                }
                else{
                    //开始或者继续动画播放
                    animationDrawable.start();
                }
            }
        });
    }

    @Override
    public Class<?> getClazz() {
        return ImageAnimationDrawableActivity.class;
    }
}
