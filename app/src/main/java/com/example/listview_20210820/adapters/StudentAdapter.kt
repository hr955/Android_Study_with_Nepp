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

    // inflate : xml 을 변수에 담을 수 있도록 해줌
    val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow == null){
            tempRow = mInflater.inflate(R.layout.item_student_list, null)
        }

        return tempRow!!
    }
}