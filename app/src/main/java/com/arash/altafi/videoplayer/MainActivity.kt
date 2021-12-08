package com.arash.altafi.videoplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.videoplayer.java.ExoPlayerJava
import com.arash.altafi.videoplayer.java.JzvdPlayerJava
import com.arash.altafi.videoplayer.kotlin.ExoPlayerKotlin
import com.arash.altafi.videoplayer.kotlin.JzvdPlayerKotlin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        btnJavaJz.setOnClickListener {
            startActivity(Intent(this , JzvdPlayerJava::class.java))
        }

        btnJavaExo.setOnClickListener {
            startActivity(Intent(this , ExoPlayerJava::class.java))
        }

        ///////////////////////////////////////////////////////////////

        btnKotlinJz.setOnClickListener {
            startActivity(Intent(this , JzvdPlayerKotlin::class.java))
        }

        btnKotlinExo.setOnClickListener {
            startActivity(Intent(this , ExoPlayerKotlin::class.java))
        }
    }

}