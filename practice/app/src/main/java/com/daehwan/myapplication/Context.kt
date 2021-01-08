package com.daehwan.myapplication

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Context : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        // 자식은 부모의 타입이 될 수 있음
        val context : Context = this
        val applicationContext = getApplicationContext()
    }
}