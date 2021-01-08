package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.daehwan.myapplication.databinding.ActivityThreadBinding

class ThreadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val runnable : Runnable = object : Runnable{
            override fun run() {
                Log.d("thread-1","Thread1 is made")
            }
        }
        val thread : Thread = Thread(runnable)
        binding.button.setOnClickListener {
            thread.start()
        }
        Thread(object : Runnable{
            override fun run() {
                Log.d("thread-1","Thread2 is made")
            }
        }).start()

        Thread(Runnable {
            Thread.sleep(2000) // 쓰레드가 2초 쉼
            Log.d("thread-1","Thread3 is made")
            runOnUiThread {
                binding.button.setBackgroundColor(getColor(R.color.textView_color))
            }

        }).start()

    }
}