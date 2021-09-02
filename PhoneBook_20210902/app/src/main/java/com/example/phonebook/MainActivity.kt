package com.example.phonebook

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    // 0. 전화번호 추가 기능 -> 별도 화면에서 저장

    // 1. 화면에 들어오면 -> 파일에 저장된 "이름,전화번호,생일(1991-05-22)" 문장을 불러오기
    // 안드로이드에서 파일 다루는법법

    // 2. 불러낸 데이터들을 -> ListView 에 뿌려주자

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()

    }

    override fun setValues() {
//        addPhoneNumBtn.setOnClickListener( object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//            }
//        })

        // 위 자바 코드를 개량한것 (람다)
        addPhoneNumBtn.setOnClickListener {
            //EditPhoneNumActivity 로 이동 : Intent
            val myIntent = Intent(mContext, EditPhoneNumActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setupEvents() {
    }

}