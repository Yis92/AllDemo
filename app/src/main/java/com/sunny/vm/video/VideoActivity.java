package com.sunny.vm.video;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.sunny.R;
import com.sunny.base.BaseActivity;

/**
 * 该实例中使用MediaPlayer完成播放，同时界面使用SurfaceView来实现
 *
 * 这里我们实现MediaPlayer中很多状态变化时的监听器
 *
 * 使用Mediaplayer时，也可以使用MediaController类，但是需要实现MediaController.mediaController接口实现一些控制方法。
 *
 * 然后，设置controller.setMediaPlayer(),setAnchorView(),setEnabled(),show()就可以了，这里不再实现
 *
 * 视频demo
 *
 * Created by liu on 16/9/29.
 */
public class VideoActivity extends BaseActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_video);
    }

    @Override
    public void initBoot() {

    }

    @Override
    public void initViews() {
        videoView = findView(R.id.video);
    }

    @Override
    public void initData(Intent intent) {
        Uri uri = Uri.parse("http://111.202.85.154/vhot2.qqvideo.tc.qq.com/w0199p5dfjs.p702.1.mp4?sdtfrom=v1000&type=mp4&vkey=35F127DC788C60976A7712B64220B69B490C13EADBF6A791BE418DFFB96205D9FD3DEB24499B3478DBC52243392CB33D7C5B9BBA30F5A69A22DDBF7C58619F4DD770CF980F1EB88725661BFF96CDD6AD97217F498B46723E553C5B3C8CD19ED88B8876E8EC8009DDD171939188BE56AEE8CD4B9B7C91E988&level=0&platform=70202&br=60&fmt=hd&sp=0&guid=D13F99EB73D0DCED6F571ECB13404811C8ECD1CC");
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.requestFocus();
    }

    @Override
    public void initEvents() {

    }

    @Override
    public Class<?> getClazz() {
        return VideoActivity.class;
    }
}
