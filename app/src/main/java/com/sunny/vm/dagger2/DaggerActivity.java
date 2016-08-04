package com.sunny.vm.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sunny.R;
import com.sunny.vm.dagger2.bean.Fruit;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by toreal on 2016/7/21.
 */
public class DaggerActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Named("typeA")
    @Inject
    Fruit fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        ButterKnife.bind(this);

        DaggerFruitComponent.create().inject(this); //7 使用FruitComponent的实现类注入
        initData();

    }

    private void initData() {
        boolean isEat = fruit.eat();
        tvTitle.setText("####"+isEat);
    }
}
