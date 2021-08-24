package com.example.librarypractice_20210824

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.example.librarypractice_20210824.base.BaseActivity
import com.gun0912.tedpermission.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        profileImg.setOnClickListener {
            startActivity(Intent(mContext, ViewPhotoActivity::class.java))
        }

        //TedPermission 라이브러리 활용 -> 권한 여부 대응 + 실제 체크
        val pl = object: PermissionListener{
            
            //권한이 있을 떄
            override fun onPermissionGranted() {

                // 전화연결 (CALL) 활용
                callBtn.setOnClickListener {
                    val myUri = Uri.parse("tel:02-5555-8888")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }
            }

            //권한이 없을 때
            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(mContext, "권한이 필요합니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setValues() {
    }
}