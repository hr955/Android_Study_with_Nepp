package com.example.intent_20210819

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1000
    val REQ_FOR_PHONE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOther.setOnClickListener {
            startActivity(Intent(this, OtherActivity::class.java))
        }

        btnSendMessage.setOnClickListener {
            val intent = Intent(this, ViewMessageActivity::class.java)
            intent.putExtra("message", edtMessage.text.toString())
            startActivity(intent)
        }

        btnEditNickname.setOnClickListener {
            val intent = Intent(this, EditNicknameActivity::class.java)
            startActivityForResult(intent, REQ_FOR_NICKNAME)

        }
    }
}