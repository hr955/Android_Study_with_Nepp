package com.example.listviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listviewpractice.adapters.FriendsAdapter
import com.example.listviewpractice.datas.FriendData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var friendList = arrayListOf<FriendData>(
            FriendData("준면", "안녕하세요", "01012345678"),
            FriendData("인준", "저는 인준이에요", "01020000323"),
            FriendData("재민", "집에 가고싶어", "010020000813"),
            FriendData("해찬", "해쨔니 와떠요", "01020000606"),
            FriendData("민형", "마꾸리", "01019990802")
        )

        lv_friend_list.adapter = FriendsAdapter(this, R.layout.activity_main, friendList)
    }
}