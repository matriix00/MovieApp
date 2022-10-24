package com.example.movieapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val runnable = Runnable { startActivity(Intent(this@SplashActivity,MainActivity::class.java)) }
        Handler(Looper.getMainLooper()).postDelayed(runnable, 5000)

    }

}