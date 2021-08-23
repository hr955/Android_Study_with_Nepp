package com.example.lifecycle_20210823

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        메모리(RAM)에 올릴 때 실행
//        액티비티가 메모리에 등록할때(안드로이드가) 실행시켜주는 함수
//        기본적으로 작성되는 코드 + 추가 동작 작성
//        메모리에 등록 : 화면에 나오기 전 -> 제일 먼저 실행
//        이 내부에 작성하는 코드들은 화면이 뜨기 전에 실행되어
//        화면이 나타나기 전에 실행된다고 보장됨
//        Intent 등으로 화면에 띄울 준비를 하는 시점에 실행(무조건 다 만들어 두고 쓰는건 X)
//        만들어 둔 액티비티로 "복귀할 떄"는 기존의 객체를 화면에 보여주기만 할 뿐, 재 생성X
//        액티비티의 시작지점으로 동작하는게 보장된 함수(남의 코드도 onCreate 부터 읽자)

        Log.d("메인화면", "onCreate 실행됨")

        moveBtn.setOnClickListener {
            startActivity(Intent(this, OtherActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

//        액티비티가 화면에 등장하려고 할때 실행되는 함수.
//        다른 액티비티를 갔다오면 다시 실행됨
//        응용 : 새글 자동 새로고침
//        <-> onPause()

        Log.d("메인화면", "onResume 실행됨")

    }

    override fun onPause() {
        super.onPause()

//        액티비티가 종료(finish)되거나 가려질 때
//        응용 : GPS 같이 자원소모가 큰 기능을 일시정지할 때
//        지도를 보며 가는 도중에 전화가 옴 -> 지도화면 onPause 후 전화 끊으면 onResume
//        <-> onResume()

//        onDestroy : 액티비티 파괴! 메모리(RAM)에서 소멸
//        GC가 메모리를 수거해가는 과정에서 실행

       Log.d("메인화면", "onPause 실행됨")

    }
}