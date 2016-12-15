package com.sunny.vm.refresh.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunny.R;

import java.util.List;

import cn.trinea.android.common.adapter.CommonAdapter;

/**
 * Created by liu on 16/12/15.
 */

public class SwipeListAdapter extends CommonAdapter<String> {

    private TextView tvNews;

    public SwipeListAdapter(Activity activity, List<String> list) {
        super(activity, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.adapter_swipe_lv_item, parent, false);
        }

        tvNews = get(convertView, R.id.tv_news);

        if (position == 3) {
            tvNews.setText("快点本宝宝,有惊喜哦~~~");
            tvNews.setTextColor(getColor(R.color.red));
        } else {
            tvNews.setText(list.get(position));
            tvNews.setTextColor(getColor(R.color.gray));
        }


        return convertView;
    }
}
