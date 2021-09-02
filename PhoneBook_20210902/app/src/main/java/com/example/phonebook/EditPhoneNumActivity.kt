package com.example.phonebook

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_edit_phone_num.*
import java.util.*

class EditPhoneNumActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_num)

        setValues()
        setupEvents()

    }

    override fun setValues() {
    }

    override fun setupEvents() {
        selectBirthDayBtn.setOnClickListener {
            // 달력처럼, 날짜 선택 팝업 출현
            val dateSetListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    // 날짜가 선택되면 실행해줄 코드 (년 / 월 / 일 세개의 Int를 가지고 처리)
                    // 날짜 선택이 완료되면 -> birthDayTxt 에 반영 (String으로 반영)
                    // Calendar -> String 가공 : SimpleDateFormat


                }
            }

            val datePickerDialog =
                DatePickerDialog(mContext, dateSetListener, 2021, Calendar.SEPTEMBER, 2)
            datePickerDialog.show()

        }
    }
}