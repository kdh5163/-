package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {

    class Car(val number: Int = 10){

    }
    lateinit var lateCar : Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number : Int = 10
        val number1 : Int? = null
        val number2 = number1?.plus(number)
        Log.d("number","number2 :"+number2)

        // 삼항현산자 -> 엘비스 연산자(?:)
        // Null Safety를 위한 도구
        val number3 = number1 ?: 10 // number1이 null이면 10이 들어감
        Log.d("number","number3 : "+number3)
        lateCar = Car()
        // 반드시 쓰기 전에 초기화 해야함
        Log.d("number","late number : "+lateCar.number)

        // 개발자가 number1이 null이 아님을 보장 -> 실수 가능성성
       //val number5 : Int = number1!! + 10

    }

    fun plus (a : Int, b : Int?) : Int {
        if (b != null) return a + b
        else return a
    }

    fun plus2 (a : Int, b : Int?) : Int? {
        return b?.plus(a)
    }
}