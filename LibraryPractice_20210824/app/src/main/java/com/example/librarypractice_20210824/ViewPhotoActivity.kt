package com.example.librarypractice_20210824

import android.os.Bundle
import com.example.librarypractice_20210824.base.BaseActivity

class ViewPhotoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_photo)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
    }
}