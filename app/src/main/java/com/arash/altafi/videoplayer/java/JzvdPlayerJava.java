package com.arash.altafi.videoplayer.java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.arash.altafi.videoplayer.R;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class JzvdPlayerJava extends AppCompatActivity {

    private JzvdStd jzvdStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzvd_player_java);

        init();
    }

    private void init() {
        findView();
        jzVideoPlayer();
    }

    private void jzVideoPlayer()
    {
        String video = "https://dl.geniusboys.ir/dark/web/part3.mp4";
        jzvdStd.setUp(video , "فیلم اول" , Jzvd.SCREEN_NORMAL);
        jzvdStd.fullscreenButton.setVisibility(View.GONE);
        jzvdStd.batteryLevel.setVisibility(View.GONE);
        jzvdStd.tinyBackImageView.setVisibility(View.GONE);
        jzvdStd.backButton.setVisibility(View.GONE);
        jzvdStd.videoCurrentTime.setVisibility(View.GONE);
        jzvdStd.titleTextView.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    private void findView() {
        jzvdStd = findViewById(R.id.jz_video_java);
    }

}