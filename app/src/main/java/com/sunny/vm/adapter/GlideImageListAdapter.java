package com.sunny.vm.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sunny.R;

import java.util.List;

import cn.trinea.android.common.adapter.CommonAdapter;

/**
 * Created by liu on 16/11/21.
 */

public class GlideImageListAdapter extends CommonAdapter<String> {

    private ImageView image;

    public GlideImageListAdapter(Activity activity, List<String> list) {
        super(activity, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null) {
            convertView = layoutInflater.inflate(R.layout.adapter_glide_image_lv_item,parent,false);
        }

        image = get(convertView,R.id.image);

        Glide.with(activity).load(list.get(position)).into(image);

        return convertView;
    }
}
