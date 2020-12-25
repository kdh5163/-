package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class Listener : AppCompatActivity() {
    var num = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        val textView: TextView = findViewById(R.id.hello)
        val img: ImageView = findViewById(R.id.gradient)
        // 익명함수
        // 1 -> 람다방식
        textView.setOnClickListener {
            Log.d("click", "Click!!")
        }

        // 2 -> 익명 함수 방식
        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
            }
        })

        // 3 -> 이름이 필요한 경우(click)
        val click = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
                textView.setText("안녕하세요")
                img.setImageResource(R.drawable.ic_launcher_foreground)
                num += 10
                Log.d("number",num.toString())
                Log.d("number","" + num)
            }
        }
        textView.setOnClickListener(click)

        // 뷰를 조작하는 함수들
        // 1 -> setText
        // 2 -> setImageResource
    }
}