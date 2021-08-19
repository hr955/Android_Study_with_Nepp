package com.example.kotlingrammar_20210819

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //코틀린 문법 연습용 프로젝트 (UI 작업X)

        val myName: String
        myName = "장혜린"
        //myName = "혜린" value는 변경 불가!!
        Log.d("변수확인", myName)

        var myBirthYear: Int
        myBirthYear = 1995
        Log.d("변수확인", myBirthYear.toString())

    }
}