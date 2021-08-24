package com.example.fragment_20210824.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment_20210824.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

//    동작 관련 코드들이 작성되는 함수 => 액티비티 : onCreate
//    이 클래스 : 화면X, 화면에 올라가는 부품 0
//    프래그먼트의 onCreate는 화면도 준비되기 전 -> 동작시키면 에러 소지가 높다

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        logBtn.setOnClickListener {
            Log.d("부품에서 찍기", "로그버튼 눌림")
        }
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//
//        logBtn.setOnClickListener {
//            Log.d("부품에서 찍기", "로그버튼 눌림")
//        }
//    }
}