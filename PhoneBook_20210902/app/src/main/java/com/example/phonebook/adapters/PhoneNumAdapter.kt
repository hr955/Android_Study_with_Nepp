package com.example.phonebook.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
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
        if (row == null) {
            row = mInflater.inflate(R.layout.phone_num_list_item, null)
        }

        row!! // row는 무조건 null 이 아니라고 강제

        // 이 아래로는 row는 null이 아닌것으로 간주
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val birthDayTxt = row.findViewById<TextView>(R.id.birthDayTxt)
        val phoneNumTxt = row.findViewById<TextView>(R.id.phoneNumTxt)
        val dialImg = row.findViewById<ImageView>(R.id.dialImg)
        val birthdayImg = row.findViewById<ImageView>(R.id.birthDayImg)


        // 데이터 꺼내와서 연결시키기
        val data = mList[position]

        nameTxt.text = data.name
        phoneNumTxt.text = data.phoneNum
        // PhoneNumData의 생년월일(Calendar)을 -> n월 n일 양식으로 가공
        birthDayTxt.text = data.getFormattedBirthday()

        // 생일이 오늘로부터 10일 이내라면 생일 이미지뷰 표시
//        if(){
//            birthdayImg.visibility = View.VISIBLE
//        }else{
//            birthdayImg.visibility = View.GONE
//        }

        dialImg.setOnClickListener {
            // DIAL 액션 Intent 활용
            val myUri = Uri.parse("tel:${data.phoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            // 어댑터 안에서, 액티비티의 기능인 startAcitivity 함수를 실행하고 싶음
            // 어댑터를 만들때 -> 화면정보를 mContext 변수에 받아옴
            mContext.startActivity(myIntent)
        }

        return row
    }
}