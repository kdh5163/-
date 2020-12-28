package com.daehwan.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.daehwan.myapplication.databinding.ActivityPracticeInternetBinding

class PracticeInternet : AppCompatActivity() {
    private lateinit var binding : ActivityPracticeInternetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticeInternetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.inputBar.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.inputBar.text.toString()))
            try {
                startActivity(intent)
            }
            catch (e : ActivityNotFoundException){
                binding.inputBar.setText("다시 입력하세요")
                binding.inputBar.setSelection(binding.inputBar.length())
            }
        }
    }
}