package com.daehwan.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // SharedPreference
//        val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
        // Mode
        // - MODE_PRIVATE : 생성한 application 에서만 사용 가능 (내가 만든 앱에서만 사용 가능)
        // - MODE_WORLD_READABLE: 다른 application에서 사용 가능 -> 읽을 수 만 있음
        // - MODE_WORLD_WRITABLE: 다른 application에서 사용 가능 -> 기록도 가능
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND : 기존 preference에 신규로 추가
//        val editor : SharedPreferences.Editor = sharedPreference.edit()
//        editor.putString("hello","안녕하세요")
//        editor.putString("goodbye","안녕가세요")
        // commit을 반드시 해주어야 데이터가 저장됨
//        editor.commit()
        // sp1 -> SharedPreference
        //        (Key,Value) -> ("Hello", "안녕하세요")
        // sp2 -> SharedPreference
        //        (Key,Value) -> ("Hello", "안녕하세요")
        // 이름이 있기 때문에 구분됨
        findViewById<Button>(R.id.save_btn).setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello","안녕하세요")
            editor.putString("goodbye","안녕히가세요")
            editor.commit()
        }
        findViewById<Button>(R.id.load_btn).setOnClickListener{
            // SharedPreference에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello","데이터 없음")
            val value2 = sharedPreference.getString("goodbye","데이터 없음")
            Log.d("key-value","Value : "+value1)
            Log.d("key-value","Value : "+value2)
        }
        findViewById<Button>(R.id.delete_btn).setOnClickListener{
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()

        }
        findViewById<Button>(R.id.delete_all_btn).setOnClickListener{
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            editor.clear()
            editor.commit()
        }
    }
}