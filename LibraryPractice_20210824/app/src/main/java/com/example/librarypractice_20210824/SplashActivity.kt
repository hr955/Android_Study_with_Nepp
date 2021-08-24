package com.example.librarypractice_20210824

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.librarypractice_20210824.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(mContext, MainActivity::class.java))
            finish()
        }, 2500)
    }

    override fun setValues() {
    }
}