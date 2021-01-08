package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.daehwan.myapplication.databinding.ActivityResourceBinding

class Resource : AppCompatActivity() {
    private lateinit var binding: ActivityResourceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResourceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //1
        val ment = resources.getString(R.string.hello)
        Log.d("mentt",""+ment)

        //2
        val ment2 = getString(R.string.hello)
        Log.d("mentt",""+ment2)

        val color = getColor(R.color.textView_color)
        Log.d("mentt",""+color)

        binding.button.setBackgroundColor(getColor(R.color.textView_color))
    }
}