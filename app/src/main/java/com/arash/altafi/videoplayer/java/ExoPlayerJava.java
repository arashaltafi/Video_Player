package com.arash.altafi.videoplayer.java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.arash.altafi.videoplayer.R;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;

public class ExoPlayerJava extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player_java);

        init();
    }

    private void init() {
        findView();
        exoPlayer();
    }

    private void exoPlayer() {

        String video = "https://dl.geniusboys.ir/dark/web/part3.mp4";
        // Create a data source factory.
        DataSource.Factory dataSourceFactory = new DefaultHttpDataSource.Factory();
        // Create a progressive media source pointing to a stream uri.
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(video));
        // Create a player instance.
        player = new SimpleExoPlayer.Builder(this).build();
        // Set the media source to be played.
        player.setMediaSource(mediaSource);
        // Prepare the player.
        player.prepare();
        player.setPlayWhenReady(true);
        playerView.setPlayer(player);
    }

    private void findView() {
        playerView = findViewById(R.id.player_view_java);
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        player.play();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
        player.pause();
    }


}