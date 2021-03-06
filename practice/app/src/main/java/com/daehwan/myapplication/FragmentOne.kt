package com.daehwan.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.daehwan.myapplication.databinding.FragmentOneBinding

class FragmentOne:Fragment(){

    interface OnDataPassListener {
        fun onDataPass(data : String?)
    }

    lateinit var dataPassListener : OnDataPassListener
    private lateinit var binding : FragmentOneBinding

    override fun onAttach(context: Context) {
        Log.d("life_cycle","F onAttach")
        super.onAttach(context)
        dataPassListener = context as OnDataPassListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle","F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle","F onCreateView")
        // 프래그먼트가 인터페이스를 처음으로 그릴 때 호출된다.
        // inflater -> 뷰를 그려주는 역할
        // container -> 부모 뷰
        binding = FragmentOneBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle","F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        // Activity 의 OnCreate 에서 했던 작업을 여기에서 한다
        binding.pass.setOnClickListener {
            dataPassListener.onDataPass("Good Bye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle","F onActivityCreated")
        val data = arguments?.getString("hello")
        Log.d("data",data)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle","F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle","F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle","F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle","F onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("life_cycle","F onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("life_cycle","F onDetach")
        super.onDetach()
    }
}