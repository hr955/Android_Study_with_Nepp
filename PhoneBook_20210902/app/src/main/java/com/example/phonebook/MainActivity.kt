package com.example.phonebook

import android.content.Intent
import android.os.Bundle
import com.example.phonebook.adapters.PhoneNumAdapter
import com.example.phonebook.datas.PhoneNumData
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.text.SimpleDateFormat

class MainActivity : BaseActivity() {

    private val mPhoneNumList = ArrayList<PhoneNumData>()

    // 1. 멤버변수로 빼는게 편한가?
    // 2. 초기화 할 때 화면정보 (Context)가 필요한가? -> 필요하다 : onCreate 내부 or 이후에서 대입
    // Hint : JAVA에서 배우는 클래스들 -> 대부분 화면 필요 X. val로 만들어도 된다
    lateinit var mAdapter: PhoneNumAdapter

    // 0. 전화번호 추가 기능 -> 별도 화면에서 저장

    // 1. 화면에 들어오면 -> 파일에 저장된 "이름,전화번호,생일(1991-05-22)" 문장을 불러오기
    // 안드로이드에서 파일 다루는법법

    // 2. 불러낸 데이터들을 -> ListView 에 뿌려주자

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()

    }

    override fun setValues() {
        // 어댑터 초기화
        mAdapter = PhoneNumAdapter(mContext, R.layout.phone_num_list_item, mPhoneNumList)

        // 리스트뷰의 어댑터로 연결
        phoneNumListView.adapter = mAdapter

        readPhoneBookFromFile()
    }

    override fun onResume() {
        super.onResume()

        // 저장 후 액티비티가 전환될때마다 새로 읽어주자
        readPhoneBookFromFile()
    }

    override fun setupEvents() {
        //        addPhoneNumBtn.setOnClickListener( object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//            }
//        })

        // 위 자바 코드를 개량한것 (람다)
        addPhoneNumBtn.setOnClickListener {
            //EditPhoneNumActivity 로 이동 : Intent
            val myIntent = Intent(mContext, EditPhoneNumActivity::class.java)
            startActivity(myIntent)
        }
    }

    // 파일에서 정보를 읽어와서 -> 리스트에 추가
    fun readPhoneBookFromFile(){
        val myFile = File(filesDir, "phoneBook.txt")

        val fr = FileReader(myFile)
        val br = BufferedReader(fr)

        //1980-07-30 String을 분석하는데 쓰일 양식
        val sdf = SimpleDateFormat("yyyy-MM-dd")

        //이 코드는 반복 실행되면 데이터가 누적으로 쌓임
        //기존에 있던 리스트를 날리고 -> 새로 데이터를 담아주기
        mPhoneNumList.clear()

        while(true){
            val line = br.readLine() ?: break

            val infos = line.split(",")
            val phoneNumData = PhoneNumData(infos[0], infos[1])

            // phoneNumData 의 생년월일을, 실제 입력한 생년월일로
            // "1991-05-09" 로 분리된 String을 기반으로 => phoneNumData의 일자로 저장. =>  (String -> Calendar)
            // SimpleDateFormat 의 parse 기능 활용
            phoneNumData.birthDay.time = sdf.parse(infos[2])

            mPhoneNumList.add(phoneNumData)
        }

        br.close()
        fr.close()

        // 내용이 추가됨을 리스트뷰도 인지해야함
        mAdapter.notifyDataSetChanged()
    }
}