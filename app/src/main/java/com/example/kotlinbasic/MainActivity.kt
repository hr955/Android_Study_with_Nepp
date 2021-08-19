package com.example.kotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logBtn02.setOnClickListener {
            Log.d("메인화면", "두번째 로그 버튼 눌림")
        }

        logBtn01.setOnClickListener {
            Log.d("메인화면","첫번째 로그 버튼 눌림")
            Log.e("메인화면", "e 로그")
            Log.i("메인화면", "i 로그")
        }
    }
}