package com.example.librarypractice_20210824

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.librarypractice_20210824.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
    }
}