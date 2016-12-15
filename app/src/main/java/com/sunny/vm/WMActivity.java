package com.sunny.vm;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mzc.ailiwm.WMAdManager;
import com.mzc.ailiwm.WMTsManager;
import com.sunny.R;

public class WMActivity extends Activity {
    private WMAdManager manager2;
    private WMAdManager manager;
    private String pid = "1530";
    private String bannerPid = "1530";
    private WMTsManager Ts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wm);
    }

    @Override
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
        if (Ts != null) {
            Ts.refresh();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Ts != null) {
            Ts.disMiss();
        }
        if (manager != null) {
            manager.closeBanner();
            manager = null;
        }
        if (manager2 != null) {
            manager2.closeBanner();
            manager2 = null;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Ts != null) {
            Ts.disMiss();
        }
        if (manager != null) {
            manager.closeBanner();
            manager = null;
        }
        if (manager2 != null) {
            manager2.closeBanner();
            manager2 = null;
        }
    }

    /**
     * 开启广告条1
     * @param v
     */
    public void click_Banner(View v) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.banner);
        if (manager == null) {
            manager = new WMAdManager(this, bannerPid, layout);
        }
    }
    /**
     * 关闭广告条1
     * @param v
     */
    public void click_closeBanner(View v) {
        if (manager != null) {
            manager.closeBanner();
            manager = null;
        }
    }

    /**
     * 开启广告条2
     * @param v
     */
    public void click_Banner2(View v) {
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.banner2);
        if (manager2 == null) {
            manager2 = new WMAdManager(this, bannerPid, layout2);
        }
    }

    /**
     * 关闭广告条2
     * @param v
     */
    public void click_closeBanner2(View v) {
        if (manager2 != null) {
            manager2.closeBanner();
            manager2 = null;
        }
    }



    public void click_Pop(View v) {
        /**
         * pid 开发者Pid 点击广告之后关闭当前广告窗口 false
         * 点击广告不关闭当前广告窗口
         */
        Ts = new WMTsManager(this, pid, true);
        Ts.init();
    }

}
