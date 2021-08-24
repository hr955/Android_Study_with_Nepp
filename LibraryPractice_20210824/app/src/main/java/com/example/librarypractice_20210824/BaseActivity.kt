package com.example.librarypractice_20210824

import androidx.appcompat.app.AppCompatActivity

// abstract : 추상 클래스 (화면에 표시 X)
abstract class BaseActivity : AppCompatActivity() {

    //this 자리에 대신 들어갈 변수
    val mContext = this

    //이벤트 처리 관련 코드를 모아줄 함수
    abstract fun setupEvents()

    //값을 띄우는 코드를 모아줄 함수
    abstract fun setValues()
}