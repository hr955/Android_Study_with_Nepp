package com.example.listview_20210820

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listview_20210820.adapters.StudentAdapter
import com.example.listview_20210820.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<StudentData>()
    lateinit var mAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(StudentData("조경진", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("권유진", 1996, "서울시 강남구"))
        mStudentList.add(StudentData("김경윤", 1997, "경기도 파주시"))
        mStudentList.add(StudentData("김현우", 1996, "서울시 마포구"))
        mStudentList.add(StudentData("김현지", 1995, "서울시 은평구"))
        mStudentList.add(StudentData("김희섭", 1989, "서울시 관악구"))
        mStudentList.add(StudentData("송병섭", 1989, "서울시 광진구"))
        mStudentList.add(StudentData("안수지", 1989, "서울시 동대문구"))
        mStudentList.add(StudentData("유병재", 1995, "경기도 부천시"))
        mStudentList.add(StudentData("이재환", 1997, "경기도 남양주시"))
        mStudentList.add(StudentData("이준서", 2000, "경기도 의왕시"))
        mStudentList.add(StudentData("장혜린", 1995, "인천시 남동구"))

        mAdapter = StudentAdapter(this, R.layout.item_student_list, mStudentList)
        studentListView.adapter = mAdapter

        studentListView.setOnItemClickListener { parent, view, position, id ->
            val clickedStudent = mStudentList[position]
            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()

        }
    }
}