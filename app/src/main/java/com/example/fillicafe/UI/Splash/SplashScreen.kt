package com.example.fillicafe.UI.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.example.fillicafe.R
import com.example.fillicafe.UI.Intro.IntroScreens
import com.example.fillicafe.UI.Login.Login
import java.util.concurrent.TimeUnit

class SplashScreen : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    private val runnable = Runnable {
        startActivity(Intent(this, IntroScreens::class.java))
        finish()
    }
    lateinit var splash_image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splash_image = findViewById(R.id.splash_image)

    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, TimeUnit.SECONDS.toMillis(2))
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }
}