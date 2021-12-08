package com.arash.altafi.videoplayer.kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cn.jzvd.Jzvd
import com.arash.altafi.videoplayer.R
import kotlinx.android.synthetic.main.activity_jzvd_player_kotlin.*

class JzvdPlayerKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jzvd_player_kotlin)

        jzVideoPlayer()
    }

    private fun jzVideoPlayer() {
        val video = "https://dl.geniusboys.ir/dark/web/part3.mp4"
        jz_video_kotlin.setUp(video, "فیلم اول", Jzvd.SCREEN_NORMAL)
        jz_video_kotlin.fullscreenButton.visibility = View.GONE
        jz_video_kotlin.batteryLevel.visibility = View.GONE
        jz_video_kotlin.tinyBackImageView.visibility = View.GONE
        jz_video_kotlin.backButton.visibility = View.GONE
        jz_video_kotlin.videoCurrentTime.visibility = View.GONE
        jz_video_kotlin.titleTextView.visibility = View.GONE
    }

    override fun onBackPressed() {
        if (Jzvd.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }

}