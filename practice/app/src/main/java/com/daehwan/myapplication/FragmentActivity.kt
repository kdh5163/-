package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.daehwan.myapplication.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {
    override fun onDataPass(data: String?) {
        Log.d("pass",data)
    }

    private lateinit var binding: ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.d("life_cycle","onCreate")
        val fragmentOne : FragmentOne = FragmentOne()
        // 프라그먼트에 data를 넣어주는 방법
        val bundle : Bundle = Bundle()
        bundle.putString("hello","hello")
        fragmentOne.arguments = bundle

        binding.button.setOnClickListener {
            // 프라그먼트를 동적으로 작동하는 방법
            // 프라그먼트 붙이는 방법 replace/add
            val fragmentManager : FragmentManager = supportFragmentManager

            // Transaction
            // 작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction() // 시작
            fragmentTransaction.replace(R.id.container1,fragmentOne)
            fragmentTransaction.commit() // 끝

            // 끝을 내는 방법
            // 1. commit    -> 시간 될 때 해 ( 좀 더 안정적 )
            // 2. commitNow -> 지금 당장 해
        }

        binding.button2.setOnClickListener {
            // 프라그먼트 remove/detach 하는 방법
            // remove -> 뗐다붙였다 가능
            // detach -> 한번 떼면 다시 못 붙임
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle","onDestroy")
    }
}