package com.example.phonebook

import android.os.Bundle

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
    }
}