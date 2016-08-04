package com.sunny.vm.rxjava_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.AndroidCharacter;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.sunny.R;
import com.sunny.bean.GetIpInfoResponse;
import com.sunny.vm.rxjava_retrofit.service.MyService;

import java.util.Scanner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by toreal on 2016/8/1.
 */
public class DemoActivity extends AppCompatActivity {

    @BindView(R.id.tv_name)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajava_retrofit);
        ButterKnife.bind(this);
    }

    /**
     * 获取我的兴趣
     */
    @OnClick(R.id.btn_interest)
    public void getInterest(){
        init();
    }

    public void showInterest(String name) {
        tvName.setText(name);
    }

    private void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://api.gb6m.com")
                .build();

        MyService myService = retrofit.create(MyService.class);
        myService.login(17026029,"b5394c981fdbceef4ab3567bbdc645a4")//获取Observable对象
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(Schedulers.io())//请求完成后再io线程中执行
                .doOnNext(new Action1<GetIpInfoResponse>() {
                    @Override
                    public void call(GetIpInfoResponse getIpInfoResponse) {
//                        showInterest(getIpInfoResponse.getData().get(0).getName());
                        Log.i("qqq",getIpInfoResponse.getData().get(0).getName());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行（rxandroid中的api）
                .subscribe(new Subscriber<GetIpInfoResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.i("qqq", "onCompleted...");
                    }

                    @Override
                    public void onError(Throwable e) {//请求失败
                        Log.i("qqq", "onError..." + e.getMessage());
                    }

                    @Override
                    public void onNext(GetIpInfoResponse getIpInfoResponse) {//请求成功
                        showInterest(getIpInfoResponse.getData().get(0).getName());
                        Log.i("qqq", "onNext...");
                    }
                });
    }
}
