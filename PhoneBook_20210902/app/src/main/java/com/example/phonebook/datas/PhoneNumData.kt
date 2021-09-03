package com.example.phonebook.datas

import java.text.SimpleDateFormat
import java.util.*

class PhoneNumData(var name: String, var phoneNumData: String) {

    // set기능으로 내부에 적힌 값을 변경 -> 새 객체를 넣는것 X
    // 변수 입장에서는 연결된 객체가 바뀔일이 없음 -> val로 만들기
    val birthDay = Calendar.getInstance() // 기본값 : 오늘 날짜

    private val fileDateFormat = SimpleDateFormat("yyyy-MM-dd")

    // 가진 데이터를 -> 파일에 저장할 수 있는 양식 "이름,폰번,생년월일" 양식으로 가공
    fun getFileFormatData(): String {
        // 코틀린에서 String을 가공
        return "${this.name},${this.phoneNumData},${fileDateFormat.format(this.birthDay.time)}}"
    }
}