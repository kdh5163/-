package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.daehwan.myapplication.databinding.ActivityPracticePlusBinding

class PracticePlus : AppCompatActivity() {
    private lateinit var binding: ActivityPracticePlusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticePlusBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var new = "0"
        var old = "0"

//        "1" + "2"="12"

        binding.one.setOnClickListener {
            new = new + "1"
            binding.result.setText(new)
        }
        binding.two.setOnClickListener {
            new = new + "2"
            binding.result.setText(new)
        }
        binding.three.setOnClickListener {
            new = new + "3"
            binding.result.setText(new)
        }
        binding.four.setOnClickListener {
            new = new + "4"
            binding.result.setText(new)
        }
        binding.five.setOnClickListener {
            new = new + "5"
            binding.result.setText(new)
        }
        binding.six.setOnClickListener {
            new = new + "6"
            binding.result.setText(new)
        }
        binding.seven.setOnClickListener {
            new = new + "7"
            binding.result.setText(new)
        }
        binding.eight.setOnClickListener {
            new = new + "8"
            binding.result.setText(new)
        }
        binding.nine.setOnClickListener {
            new = new + "9"
            binding.result.setText(new)
        }
        binding.zero.setOnClickListener {
            new = new + "0"
            binding.result.setText(new)
        }

        binding.plus.setOnClickListener {
            old = (old.toLong() + new.toLong()).toString()
            new = "0"
            binding.result.setText(old)
        }

        binding.CA.setOnClickListener {
            new = "0"
            old = "0"
            binding.result.setText("0")
        }
    }
}