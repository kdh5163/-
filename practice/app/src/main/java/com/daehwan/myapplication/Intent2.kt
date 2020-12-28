package com.daehwan.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.daehwan.myapplication.databinding.ActivityIntent2Binding

class Intent2 : AppCompatActivity() {
    private lateinit var binding: ActivityIntent2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntent2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val number1 = intent.getIntExtra("number1",0)
        val number2 = intent.getIntExtra("number2",0)

        Log.d("number",""+number1)
        Log.d("number",""+number2)

        // 결과값 반환
        binding.result.setOnClickListener {
            val result = number1 + number2
            val resultIntent = Intent()
            resultIntent.putExtra("result",result)
            setResult(RESULT_OK,resultIntent)
            this.finish() // Activity 종료
        }
    }
}