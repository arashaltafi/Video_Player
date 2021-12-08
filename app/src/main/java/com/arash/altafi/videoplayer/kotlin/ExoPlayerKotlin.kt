package com.arash.altafi.videoplayer.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.videoplayer.R
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import kotlinx.android.synthetic.main.activity_exo_player_kotlin.*

class ExoPlayerKotlin : AppCompatActivity() {

    private var player : SimpleExoPlayer ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exo_player_kotlin)

        exoPlayer()
    }

    private fun exoPlayer() {
        val video = "https://dl.geniusboys.ir/dark/web/part3.mp4"
        // Create a data source factory.
        val dataSourceFactory : DataSource.Factory = DefaultHttpDataSource.Factory()
        // Create a progressive media source pointing to a stream uri.
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(video))
        // Create a player instance.
        player = SimpleExoPlayer.Builder(this).build()
        // Set the media source to be played.
        player!!.setMediaSource(mediaSource)
        // Prepare the player.
        player!!.prepare()
        player!!.playWhenReady = true
        player_view_kotlin.player = player
    }

    override fun onStop() {
        super.onStop()
        player!!.pause()
    }

    override fun onRestart() {
        super.onRestart()
        player!!.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        player!!.release()
        player!!.pause()
    }

}