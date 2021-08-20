package com.example.listviewpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.listviewpractice.R
import com.example.listviewpractice.datas.FriendData

class FriendsAdapter(
    private val mContext: Context,
    private val resId: Int,
    private val mList: ArrayList<FriendData>
) : ArrayAdapter<FriendData>(mContext, resId, mList) {

    val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null){
            tempRow = mInflater.inflate(R.layout.item_friend_list, null)
        }

        var row = tempRow!!

        return row
    }
}