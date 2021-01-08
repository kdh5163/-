package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.daehwan.myapplication.databinding.ActivityPracticeInternetBinding
import com.daehwan.myapplication.databinding.ActivityPracticePhoneIntentBinding

class PracticePhoneIntent : AppCompatActivity() {
    private lateinit var binding : ActivityPracticePhoneIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticePhoneIntentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.name.setText(intent.getStringExtra("name"))
        binding.num.setText(intent.getStringExtra("num"))

    }
}