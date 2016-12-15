package com.sunny.vm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.sunny.R;
import com.sunny.base.BaseActivity;
import com.sunny.vm.adapter.GlideImageListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 16/11/21.
 */

public class GlideImageDemoActivity extends BaseActivity {

    private ImageView image;
    private ListView lvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_glide_image_demo);
    }

    @Override
    public void initBoot() {

    }

    @Override
    public void initViews() {
        image = findView(R.id.image);
        lvContent = findView(R.id.lv_content);
    }

    @Override
    public void initData(Intent intent) {

        Glide.with(activity).load("http://images2.zhixiaoxinwen.net/201611/18/1479457598_87005100.jpg").into(image);

        List<String> list = new ArrayList<>();
        list.add("http://images2.zhixiaoxinwen.net/201611/18/1479457598_87005100.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=2703214039,727310962&fm=23&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=1182721909,2081701680&fm=23&gp=0.jpg");
        list.add("http://pic20.nipic.com/20120412/2679786_171526560175_2.jpg");
        list.add("http://img2.3lian.com/img2009/04/3lian12/3lian-com_017.jpg");


        GlideImageListAdapter adapter = new GlideImageListAdapter(activity,list);
        lvContent.setAdapter(adapter);
    }

    @Override
    public void initEvents() {

    }

    @Override
    public Class<?> getClazz() {
        return GlideImageDemoActivity.class;
    }
}
