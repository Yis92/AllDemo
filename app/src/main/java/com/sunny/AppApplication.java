package com.sunny;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.sunny.constant.Constant;

import java.io.File;

import cn.trinea.android.common.configure.Config;
import cn.trinea.android.common.util.PreferenceHelper;

/**
 * Created by sunny on 15/10/15.
 */
public class AppApplication extends Application {

    private static Context context;
    private static PreferenceHelper preferenceHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initImageLoader(context);
        Config.PREFERENCE_NAME = Constant.XINWEN_PRE_NAME;
    }

    public static Context getContext() {
        return context;
    }

    /**
     * 获取数据存储
     *
     * @return
     */
    public static PreferenceHelper getPreferenceHelper() {
        synchronized (AppApplication.class) {
            if (preferenceHelper == null) {
                preferenceHelper = new PreferenceHelper(context);
            }
        }
        return preferenceHelper;
    }

    /**
     * imageLoader 加载
     *
     * @param context
     */
    private static void initImageLoader(Context context) {
        File cacheDir = StorageUtils.getCacheDirectory(context);
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        // ImageLoaderConfiguration.createDefault(this);
        // method.
        //ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).discCache(new UnlimitedDiscCache(cacheDir)).tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs()
        //.build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPoolSize(5)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(10 * 1024 * 1024))
                .memoryCacheSize(10 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024) // 50 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

}
