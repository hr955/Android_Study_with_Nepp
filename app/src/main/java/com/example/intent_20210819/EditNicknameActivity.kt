package com.example.intent_20210819

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        btnOK.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("nick", edtNickName.text.toString())

            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }
    }
}