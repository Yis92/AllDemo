package com.sunny;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sunny.base.BaseActivity;
import com.sunny.bean.ApiService;
import com.sunny.bean.GetIpInfoResponse2;
import com.sunny.test.IndexAdvActivity;
import com.sunny.util.SystemStatusManager;
import com.sunny.vm.DemoActivity;
import com.sunny.vm.GlideImageDemoActivity;
import com.sunny.vm.ImageAnimationDrawableActivity;
import com.sunny.vm.WMActivity;
import com.sunny.vm.adv.AdvShowActivity;
import com.sunny.vm.dagger2.DaggerActivity;
import com.sunny.vm.mvp.UserLoginActivity;
import com.sunny.vm.refresh.SwipeRefreshLayoutActivity;
import com.sunny.vm.rxjava.RxjavaActivity;
import com.sunny.vm.video.VideoActivity;

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
    private Button btnVideo;
    private Button btnZhida;
    private Button btnGlide;
    private Button btnAdv;
    private Button btnSflRefresh;

    private LinearLayout llMain;


    // 需要setContentView之前调用
    private void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            SystemStatusManager tintManager = new SystemStatusManager(this);
            tintManager.setStatusBarTintEnabled(true);
            // 设置状态栏的颜色
            tintManager.setStatusBarTintResource(R.color.error_color);
            getWindow().getDecorView().setFitsSystemWindows(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTranslucentStatus();
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
        btnVideo = findView(R.id.btn_video);
        btnZhida = findView(R.id.btn_zhida);
        btnGlide = findView(R.id.btn_glide);
        btnAdv = findView(R.id.btn_adv);
        btnSflRefresh = findView(R.id.btn_sfl_refresh);
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
//              startActivity(LoginDesignActivity.class);
              startActivity(IndexAdvActivity.class);
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

                Call<GetIpInfoResponse2> call = apiService.getIpInfo(17026029,"b5394c981fdbceef4ab3567bbdc645a4");

                call.enqueue(new Callback<GetIpInfoResponse2>() {
                    @Override
                    public void onResponse(Call<GetIpInfoResponse2> call, Response<GetIpInfoResponse2> response) {
                        Log.i("qqq","code:::"+response.code());

                        GetIpInfoResponse2 getIpInfoResponse = response.body();
                        Log.i("qqq",getIpInfoResponse.getData().get(0).getName());
                        Log.i("qqq",getIpInfoResponse.getMessage());
                    }

                    @Override
                    public void onFailure(Call<GetIpInfoResponse2> call, Throwable t) {
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
        //
        btnZhida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(WMActivity.class);
            }
        });

        //
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Test_Movie.m4v");
//                //调用系统自带的播放器
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                Log.v("URI:::::::::", uri.toString());
//                intent.setDataAndType(uri, "http://111.202.85.154/vhot2.qqvideo.tc.qq.com/w0199p5dfjs.p702.1.mp4?sdtfrom=v1000&type=mp4&vkey=35F127DC788C60976A7712B64220B69B490C13EADBF6A791BE418DFFB96205D9FD3DEB24499B3478DBC52243392CB33D7C5B9BBA30F5A69A22DDBF7C58619F4DD770CF980F1EB88725661BFF96CDD6AD97217F498B46723E553C5B3C8CD19ED88B8876E8EC8009DDD171939188BE56AEE8CD4B9B7C91E988&level=0&platform=70202&br=60&fmt=hd&sp=0&guid=D13F99EB73D0DCED6F571ECB13404811C8ECD1CC");
//                startActivity(intent);
                startActivity(VideoActivity.class);
            }
        });
        //
        btnGlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(GlideImageDemoActivity.class);
            }
        });

        //adv原生广告
        btnAdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AdvShowActivity.class);
            }
        });

        //谷歌上下刷新
        btnSflRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SwipeRefreshLayoutActivity.class);
            }
        });
    }

    @Override
    public Class<?> getClazz() {
        return MainActivity.class;
    }
}
