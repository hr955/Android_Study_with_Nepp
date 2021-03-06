package com.example.listviewpractice.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
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

        if (tempRow == null) {
            tempRow = mInflater.inflate(R.layout.item_friend_list, null)
        }

        var row = tempRow!!

        val data = mList[position]
        var txtName = row.findViewById<TextView>(R.id.txt_name)
        var txtMessage = row.findViewById<TextView>(R.id.txt_message)
        var btnDial = row.findViewById<Button>(R.id.btn_dial)

        txtName.text = data.name
        txtMessage.text = data.message

        btnDial.setOnClickListener {
            val uri = Uri.parse("tel:${data.phoneNum}")
            context.startActivity(Intent(Intent.ACTION_DIAL, uri))
        }

        return row
    }
}