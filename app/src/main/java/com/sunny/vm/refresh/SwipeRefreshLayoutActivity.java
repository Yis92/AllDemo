package com.sunny.vm.refresh;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sunny.R;
import com.sunny.base.BaseActivity;
import com.sunny.vm.refresh.adapter.SwipeListAdapter;
import com.sunny.vm.widget.SuperRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 16/12/15.
 */

public class SwipeRefreshLayoutActivity extends BaseActivity {

    private SuperRefreshLayout mRefreshLayout;

    private ListView listView;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_swipe_refresh);
    }


    @Override
    public void initBoot() {

    }

    @Override
    public void initViews() {
        mRefreshLayout = findView(R.id.superRefreshLayout);
        listView = findView(R.id.listView);
    }

    @Override
    public void initData(Intent intent) {

        mRefreshLayout.setColorSchemeResources(
                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
                R.color.swiperefresh_color3, R.color.swiperefresh_color4);


        mRefreshLayout.setCanLoadMore(listView);//是否可以加载更多

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add("挺好的都是这样得哈看见的可就是巴拉巴拉 是是是   ");
        }

        SwipeListAdapter adapter = new SwipeListAdapter(activity, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void initEvents() {
        //监听上下拉加载
        mRefreshLayout.setSuperRefreshLayoutListener(new SuperRefreshLayout.SuperRefreshLayoutListener() {
            @Override
            public void onRefreshing() {
                //下拉刷新
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //模拟请求接口
                        mRefreshLayout.onLoadComplete();
                    }
                }, 4000);
            }

            @Override
            public void onLoadMore() {
                //上拉加载更多
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //模拟请求接口
                        mRefreshLayout.setFooterType(3);//有1,2,3,4四个参数,改变参数有惊喜哦
                    }
                }, 2000);
            }
        });

        //
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 3) {
                    //点击出现下拉刷新
                    showToast("自己也会刷新的宝宝~~~~萌萌哒");
                    mRefreshLayout.setRefreshing(true);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mRefreshLayout.onLoadComplete();
                        }
                    }, 4000);
                }
            }
        });
    }

    @Override
    public Class<?> getClazz() {
        return SwipeRefreshLayoutActivity.class;
    }


}
