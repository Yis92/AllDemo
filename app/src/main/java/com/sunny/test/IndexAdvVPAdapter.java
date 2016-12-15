package com.sunny.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.sunny.R;

import java.util.List;

/**
 * Created by liu on 16/9/12.
 */
public class IndexAdvVPAdapter extends PagerAdapter {

    private Context context;
    private List<String> list;

    private ImageLoader imageLoader = ImageLoader.getInstance();

    public IndexAdvVPAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        @SuppressLint("InflateParams") View v = LayoutInflater.from(context).inflate(R.layout.adapter_index_adv_vp_item, null);

//        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
//        tvTitle.setText(list.get(position));
        ImageView ivTitle = (ImageView) v.findViewById(R.id.iv_title);
        imageLoader.displayImage(list.get(position), ivTitle);

        container.addView(v);

        return v;
    }
}
