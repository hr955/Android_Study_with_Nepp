package com.example.librarypractice_20210824

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.example.librarypractice_20210824.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        profileImg.setOnClickListener {
            startActivity(Intent(mContext, ViewPhotoActivity::class.java))
        }

        callBtn.setOnClickListener {
            val myUri = Uri.parse("tel:02-5555-8888")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }
    }

    override fun setValues() {
    }
}