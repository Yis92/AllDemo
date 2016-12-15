package com.sunny.test;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.ListView;
import com.sunny.R;
import com.sunny.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 16/9/12.
 */
public class IndexAdvActivity extends BaseActivity {

    private ListView lvContent;
    private ViewPager vpContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_index_adv);
    }

    @Override
    public void initBoot() {

    }

    @Override
    public void initViews() {
        lvContent = findView(R.id.lv_content);
        vpContent = findView(R.id.vp_content);
    }

    @Override
    public void initData(Intent intent) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add("titlr....");
        }
        TestListAdapter adapter = new TestListAdapter(activity, list);
        lvContent.setAdapter(adapter);

//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            list.add("http://img3.imgtn.bdimg.com/it/u=1710405152,1210183381&fm=21&gp=0.jpg");
//        }
//
//        IndexAdvVPAdapter advVPAdapter = new IndexAdvVPAdapter(activity,list);
//        vpContent.setAdapter(advVPAdapter);

    }

    @Override
    public void initEvents() {

    }

    @Override
    public Class<?> getClazz() {
        return IndexAdvActivity.class;
    }
}
