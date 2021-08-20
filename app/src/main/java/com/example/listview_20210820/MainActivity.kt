package com.example.listview_20210820

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview_20210820.datas.StudentData

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<StudentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add( StudentData("권유진",1996, "서울시 강남구") )
        mStudentList.add( StudentData("김경윤",1997, "경기도 파주시") )
        mStudentList.add( StudentData("김현우",1996, "서울시 마포구") )
        mStudentList.add( StudentData("김현지",1995, "서울시 은평구") )
        mStudentList.add( StudentData("송병섭",1989, "서울시 관악구") )
        mStudentList.add( StudentData("안수지",1989, "서울시 광진구") )
        mStudentList.add( StudentData("유병재",1995, "서울시 동대문구") )
        mStudentList.add( StudentData("이재환",1997, "경기도 부천시") )
        mStudentList.add( StudentData("이준서",1995, "경기도 남양주시") )
        mStudentList.add( StudentData("장혜린",1995, "인천시 남동구") )

    }
}