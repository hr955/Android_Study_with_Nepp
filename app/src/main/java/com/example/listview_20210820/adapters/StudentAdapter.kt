package com.example.listview_20210820.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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
        var tempRow = convertView

        //convertView 내부가 비어있다면, 새로운 xml 을 가져와서 채워줌
        if (tempRow == null) {
            tempRow = mInflater.inflate(R.layout.item_student_list, null)
        }

        return tempRow!!
    }
}