package com.example.listview_20210820.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.example.listview_20210820.datas.StudentData

class StudentAdapter(
    private val mContext: Context,
    private val resId: Int,
    private val mList: ArrayList<StudentData>
) : ArrayAdapter<StudentData>(mContext, resId, mList) {

}