package com.sunny.test;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunny.R;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.common.adapter.CommonAdapter;

/**
 * Created by liu on 16/9/12.
 */
public class TestListAdapter extends CommonAdapter<String> {

    private TextView tvTitle;
    private ViewPager vpContent;

    public TestListAdapter(Activity activity, List<String> list) {
        super(activity, list);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view ==null) {
            view = layoutInflater.inflate(R.layout.adapter_test_lv_item,viewGroup,false);
        }

        tvTitle = get(view,R.id.tv_title);
        vpContent = get(view,R.id.vp_content);

        tvTitle.setText(list.get(i));

        List<String> list22 = new ArrayList<>();
        for (int j = 0; j < 12; j++) {
            list22.add("http://img3.imgtn.bdimg.com/it/u=1710405152,1210183381&fm=21&gp=0.jpg");
        }

        IndexAdvVPAdapter advVPAdapter = new IndexAdvVPAdapter(activity,list22);
        vpContent.setAdapter(advVPAdapter);

        return view;
    }
}
