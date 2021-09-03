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
import java.util.*

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
        val birthdayImg = row.findViewById<ImageView>(R.id.birthdayImg)


        // 데이터 꺼내와서 연결시키기
        val data = mList[position]

        nameTxt.text = data.name
        phoneNumTxt.text = data.phoneNum
        // PhoneNumData의 생년월일(Calendar)을 -> n월 n일 양식으로 가공
        birthDayTxt.text = data.getFormattedBirthday()

        // (올해의)생일이 오늘로부터 10일 이내라면 생일 이미지뷰 표시
        // 생년월일 -> 올해의 생일로 변경하여 오늘 날짜랑 비교
        val tempBirthday = Calendar.getInstance()
        // 원본 생일 변수에 적힌 날짜를 그대로 가져옴
        tempBirthday.time = data.birthDay.time

        val today = Calendar.getInstance() // 오늘 날짜
        // 오늘 날짜의 년도를 가져와 임시 생일의 년도로 세팅
        // tempBirthday = 올해 생일로 세팅
        tempBirthday.set(Calendar.YEAR, today.get(Calendar.YEAR))

        // 생일 - 오늘 => 10일 이내? => 두 날짜를 모두 숫자로 변경
        val diffInMillis = tempBirthday.timeInMillis - today.timeInMillis
        // 1/1000 초 까지 계산된 시간차이를 -> 날짜로 변환
        // 계산 결과가 0보다 작다면 -> 생일이 오늘보다 이전이다
        val diffInDays = diffInMillis / 1000 / 60 / 60 / 24

        if(diffInDays in 0..10){
            birthdayImg.visibility = View.VISIBLE
        }else{
            birthdayImg.visibility = View.GONE
        }

        dialImg.setOnClickListener {
            // DIAL 액션 Intent 활용
            val myUri = Uri.parse("tel:${data.phoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            // 어댑터 안에서, 액티비티의 기능인 startActivity 함수를 실행하고 싶음
            // 어댑터를 만들때 -> 화면정보를 mContext 변수에 받아옴
            mContext.startActivity(myIntent)
        }

        return row
    }
}