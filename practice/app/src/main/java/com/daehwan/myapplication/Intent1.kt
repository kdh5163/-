package com.daehwan.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.daehwan.myapplication.databinding.ActivityIntentBinding

class Intent1 : AppCompatActivity() {
    private lateinit var binding: ActivityIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.changeActivity.setOnClickListener {
//            val intent = Intent(this@Intent1, Intent2::class.java) //intent1 에서 intent2로 이동하겠다.
//            intent.putExtra("number1",1) // 데이터 보내기 -> key,value 방식
//            intent.putExtra("number2",2)
//            startActivity(intent)

            val intent2 = Intent(this@Intent1,Intent2::class.java)
            // Apply -> apply를 사용하면 intent2 대신 this 사용가능해짐 블록으로 묶어서 보기 편해짐
            intent2.apply {
                this.putExtra("number1",1)
                this.putExtra("number2",2)
            }
            // startActivity : 전달만 하는 요청, startActivityForReuslt : 리턴을 받는 요청, 리턴 요청 구분을 위해 정수 코드 설정
            startActivityForResult(intent2,200)

            // 암시적 인텐트
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
//            startActivity(intent)
        }
    }

    //결과값 받기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // 내가 보낸 요청인지 확인
        if (requestCode == 200){
            // 결과 받기
            val result = data?.getIntExtra("result",0)
            Log.d("number",""+result)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}