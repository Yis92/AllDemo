package com.sunny.vm.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sunny.R;
import com.sunny.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.trinea.android.common.util.ToastUtils;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by toreal on 2016/7/27.
 */
public class RxjavaActivity extends AppCompatActivity {

    private String tag = "qqq";

    @BindView(R.id.btn_show_message)
    Button btnShowMessage;

    @BindView(R.id.btn_send_message)
    Button btnSendMessage;

    @BindView(R.id.tv_show_message)
    TextView tvShowMessage;

    Observer<String> observer;
    Observable observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        ButterKnife.bind(this);

    }

    /**
     * 发送
     */
    @OnClick(R.id.btn_send_message)
    public void setBtnSendMessage(){
        observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello");
//                subscriber.onNext("Hi");
//                subscriber.onNext("Aloha");
//                subscriber.onCompleted();
            }
        });
        observable.subscribe(observer);
    }

    /**
     * 接收
     */
    @OnClick(R.id.btn_show_message)
    public void showMessage(){
        observer = new Observer<String>() {
            @Override
            public void onNext(String s) {
                Log.d(tag, "Item: " + s);
                ToastUtils.show(RxjavaActivity.this,s);
            }

            @Override
            public void onCompleted() {
                Log.d(tag, "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag, "Error!");
            }
        };
    }
}
