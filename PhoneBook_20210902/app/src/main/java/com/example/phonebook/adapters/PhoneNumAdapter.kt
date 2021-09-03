package com.example.phonebook.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.phonebook.R
import com.example.phonebook.datas.PhoneNumData

class PhoneNumAdapter(
    val mContext: Context,
    resId: Int,
    val mList: List<PhoneNumData>
) :
    ArrayAdapter<PhoneNumData>(mContext, resId, mList) {

    val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // getView : xml (우리가 만든 xml로 커스텀) -> position에 맞는 데이터를 입혀서 -> 리스트뷰의 각 position에 뿌려주기

        var row = convertView
        if(row == null){
            row = mInflater.inflate(R.layout.phone_num_list_item, null)
        }

        row!! // row는 무조건 null 이 아니라고 강제

        // 이 아래로는 row는 null이 아닌것으로 간주
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val birthDayTxt = row.findViewById<TextView>(R.id.birthDayTxt)

        return row
    }
}