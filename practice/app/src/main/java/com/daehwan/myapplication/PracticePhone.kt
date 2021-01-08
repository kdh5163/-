package com.daehwan.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.daehwan.myapplication.databinding.ActivityPracticePhoneBinding

class PracticePhone : AppCompatActivity() {
    private lateinit var binding : ActivityPracticePhoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticePhoneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val list = ArrayList<Phone>()
        for (i in 0 until 30){
            list.add(Phone(""+i+"번째 이름","010"+i+i+i))
        }

        val container = binding.container
        val inflater = LayoutInflater.from(this@PracticePhone)
        val intent = Intent(this@PracticePhone,PracticePhoneIntent::class.java)

        for (i in 0 until list.size){
            val itemView = inflater.inflate(R.layout.practice_item_view,null)
            val name = itemView.findViewById<TextView>(R.id.name)
            name.setText(list.get(i).name)
            container.addView(itemView)
            name.setOnClickListener {
                intent.putExtra("name",list.get(i).name)
                intent.putExtra("num",list.get(i).num)
                startActivity(intent)
            }
        }


    }
}

class Phone(val name : String,val num : String)