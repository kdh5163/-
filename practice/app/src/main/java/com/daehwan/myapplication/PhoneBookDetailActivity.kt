package com.daehwan.myapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PhoneBookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)

        getPersonInfoAndDraw()

        val back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            onBackPressed() // 사용자가 뒤로가기 버튼을 누른것과 동일한 효과를 줌
        }
    }
    fun getPersonInfoAndDraw(){
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        val person_detail_name = findViewById<TextView>(R.id.person_detail_name)
        val person_detail_number = findViewById<TextView>(R.id.person_detail_number)
        person_detail_name.setText(name)
        person_detail_number.setText(number)
    }
}