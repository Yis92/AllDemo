package com.sunny;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.sunny.base.BaseActivity;
import com.sunny.bean.ApiService;
import com.sunny.bean.GetIpInfoResponse;
import com.sunny.vm.DemoActivity;
import com.sunny.vm.ImageAnimationDrawableActivity;
import com.sunny.vm.LoginDesignActivity;
import com.sunny.vm.dagger2.DaggerActivity;
import com.sunny.vm.mvp.UserLoginActivity;
import com.sunny.vm.rxjava.RxjavaActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends BaseActivity {

    private Button btnLogin;
    private Button btnImageAnimation;
    private Button btnAfinal;
    private Button btnMvp;
    private Button btnDagger;
    private Button btnDemo;
    private Button btnRetrofit;
    private Button btnRxjava;
    private Button btnRxjavaRetrofit;

    private LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
    }

    @Override
    public void initBoot() {

    }

    @Override
    public void initViews() {
        btnLogin = findView(R.id.btn_login);
        btnImageAnimation = findView(R.id.btn_image_animation);
        btnAfinal = findView(R.id.btn_afinal);
        btnMvp = findView(R.id.btn_mvp);
        btnDagger = findView(R.id.btn_dagger);
        btnDemo = findView(R.id.btn_demo);
        btnRetrofit = findView(R.id.btn_retrofit);
        llMain = findView(R.id.ll_main);
        btnRxjava = findView(R.id.btn_rxjava);
        btnRxjavaRetrofit = findView(R.id.btn_rxjava_retrofit);
    }

    @Override
    public void initData(Intent intent) {

    }

    @Override
    public void initEvents() {
        //登陆
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(LoginDesignActivity.class);
            }
        });
        //微信红包金币旋转动画效果
        btnImageAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ImageAnimationDrawableActivity.class);
            }
        });
        //afinal
        btnAfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //mvp
        btnMvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(UserLoginActivity.class);
            }
        });
        //dagger2
        btnDagger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(DaggerActivity.class);
            }
        });

        //
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(DemoActivity.class);
            }
        });

        //
        llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("123123");
            }
        });

        //
        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://api.gb6m.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);

                Call<GetIpInfoResponse> call = apiService.getIpInfo(17026029,"b5394c981fdbceef4ab3567bbdc645a4");
                call.enqueue(new Callback<GetIpInfoResponse>() {
                    @Override
                    public void onResponse(Call<GetIpInfoResponse> call, Response<GetIpInfoResponse> response) {
                        GetIpInfoResponse getIpInfoResponse = response.body();
                        Log.i("qqq",getIpInfoResponse.getData().get(0).getName());
                        Log.i("qqq",getIpInfoResponse.getMessage());
                    }

                    @Override
                    public void onFailure(Call<GetIpInfoResponse> call, Throwable t) {
                        Log.i("qqq",t.getMessage());
                    }

                });
            }
        });

        //
        btnRxjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(RxjavaActivity.class);
            }
        });
        //
        btnRxjavaRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(com.sunny.vm.rxjava_retrofit.DemoActivity.class);
            }
        });
    }

    @Override
    public Class<?> getClazz() {
        return MainActivity.class;
    }
}
