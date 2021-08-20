package com.example.listview_20210820.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listview_20210820.R
import com.example.listview_20210820.datas.StudentData

class StudentAdapter(
    private val mContext: Context,
    private val resId: Int,
    private val mList: ArrayList<StudentData>
) : ArrayAdapter<StudentData>(mContext, resId, mList) {

    // inflater : xml을 코틀린에서 다룰 수 있도록 도와주는 도구
    val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //convertView 재사용에 사용할 View 를 담는 변수
        var tempRow = convertView

        //convertView 내부가 비어있다면, 새로운 xml 을 가져와서 채워줌
        if (tempRow == null) {
            tempRow = mInflater.inflate(R.layout.item_student_list, null)
        }

        val row = tempRow!!

        //row 가 결과로 (화면에) 나가기 전에 -> 추가적인 가공을 거치고 나가게 함
        val data = mList[position]

        var txtName = row.findViewById<TextView>(R.id.txt_name)
        var txtBirthYear = row.findViewById<TextView>(R.id.txt_birth_year)
        var txtAddress = row.findViewById<TextView>(R.id.txt_address)

        txtName.text = data.name
        txtBirthYear.text = "(${2021 - data.birthYear + 1} 세)"
        txtAddress.text = data.address

        return row
    }
}