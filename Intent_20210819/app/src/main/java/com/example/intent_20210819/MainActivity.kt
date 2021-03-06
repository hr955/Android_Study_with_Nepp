package com.example.intent_20210819

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1000

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

        btnDial.setOnClickListener {
            val myUri = Uri.parse("tel:${edtPhoneNum.text}")
            startActivity(Intent(Intent.ACTION_DIAL, myUri))
        }

        btnCall.setOnClickListener {
            val myUri = Uri.parse("tel:${edtPhoneNum.text}")
            startActivity(Intent(Intent.ACTION_CALL, myUri))
        }

        btnSendTo.setOnClickListener {
            val myUri = Uri.parse("smsto:${edtPhoneNum.text}")
            val intent = Intent(Intent.ACTION_SENDTO, myUri)

            intent.putExtra("sms_body","자동으로 입력할 내용")
            startActivity(intent)
        }

        btnNaver.setOnClickListener {
            val myUri = Uri.parse("https://www.naver.com")
            startActivity(Intent(Intent.ACTION_VIEW, myUri))
        }

        btnKakaoStore.setOnClickListener {
            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            startActivity(Intent(Intent.ACTION_VIEW, myUri))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {
                tvNickname.text = data?.getStringExtra("nick")
            }
        }
    }
}