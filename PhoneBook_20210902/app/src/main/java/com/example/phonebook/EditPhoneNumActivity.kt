package com.example.phonebook

import android.app.DatePickerDialog
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.DatePicker
import com.example.phonebook.datas.PhoneNumData
import kotlinx.android.synthetic.main.activity_edit_phone_num.*
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*

class EditPhoneNumActivity : BaseActivity() {

    // 선택된 날짜의 기본값
    val mSelectedDate = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_num)

        setValues()
        setupEvents()

    }

    override fun setValues() {
    }

    override fun setupEvents() {

        okBtn.setOnClickListener {
            // 1. 입력한 값들을 변수에 저장
            val inputName = nameEdt.text.toString()
            val inputPhoneNum = phoneNumEdt.text.toString()
            // 생년월일 -> yyyy-MM-dd 형태로 가공
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            // val birthDayStr = sdf.format(mSelectedDate.time) -> PhoneNumData에서 처리

            // 2. 전화번호 데이터 객체로 만들기 (클래스 추가)
            val savePhoneNumData = PhoneNumData(inputName, inputPhoneNum)
            // PhoneNumData의 생년월일 -> 선택한 날짜에 적힌 년월일 그대로 대입
            // 하나의 Calendar 값 -> 다른 Calendar에 옮겨적기
            savePhoneNumData.birthDay.time = mSelectedDate.time

            // 3. 전화번호를 "이름,전화번호,생년월일" 양식으로 가공 -> 파일에 저장
            Log.d("EditPhoneNumActivityLog", savePhoneNumData.getFileFormatData())
            savePhoneNumToFile(savePhoneNumData.getFileFormatData())
        }

        selectBirthDayBtn.setOnClickListener {
            // 달력처럼, 날짜 선택 팝업 출현
            // object 객체를 만듦
            val dateSetListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    // 날짜가 선택되면 실행해줄 코드 (년 / 월 / 일 세개의 Int를 가지고 처리)
                    mSelectedDate.set(year, month, dayOfMonth)

                    // 날짜 선택이 완료되면 -> birthDayTxt 에 반영 (String으로 반영)
                    // Calendar -> String 가공 : SimpleDateFormat
                    // 1980. 07. 30. 양식으로 가공

                    val sdf = SimpleDateFormat("yyyy. MM. dd.")
                    birthDayTxt.text = sdf.format(mSelectedDate.time)
                }
            }

            // 달력 띄울때 기본 설정값 -> 오늘 날짜
            val datePickerDialog =
                DatePickerDialog(
                    mContext,
                    dateSetListener,
                    mSelectedDate.get(Calendar.YEAR),
                    mSelectedDate.get(Calendar.MONTH),
                    mSelectedDate.get(Calendar.DAY_OF_MONTH)
                )
            datePickerDialog.show()
        }
    }

    // 문장을 넘겨 받아서, 기기의 파일에 기록해주는 기능
    fun savePhoneNumToFile(content: String) {
        val myFile = File(filesDir, "phoneBook.txt")

        val fw = FileWriter(myFile, true)
        val bw = BufferedWriter(fw)

        bw.append(content)
        bw.newLine()

        bw.close()
        fw.close()

        Log.d("EditPhoneNumActivityLog", content)
    }
}