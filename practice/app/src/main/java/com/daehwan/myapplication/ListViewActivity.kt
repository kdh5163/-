package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 10){
            carList.add(CarForList(""+i+"번째 자동차",""+i+"순위 엔진"))
        }
        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            // 화면 아래에 말풍선 보여줌
            Toast.makeText(this@ListViewActivity,carName+" "+carEngine,Toast.LENGTH_SHORT).show()
        }

    }
}

class ListViewAdapter(val carForList: ArrayList<CarForList>, val layoutInflater : LayoutInflater) : BaseAdapter(){
    override fun getCount(): Int {
        // 그리고자 하는 아이템 리스트의 개수
        return carForList.size
    }

    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트 하나(포지션에 해당하는)
        return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션에 위치해 있는 아이템 뷰의 아이디
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view = layoutInflater.inflate(R.layout.item_view,null)
//        val carNameTextView = view.findViewById<TextView>(R.id.car_name)
//        val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
//
//        carNameTextView.setText(carForList.get(position).name)
//        carEngineTextView.setText(carForList.get(position).engine)
//
//        return view

        // 개선된 버전
        val view : View
        val holder : ViewHolder

        if (convertView == null){
            view = layoutInflater.inflate(R.layout.item_view,null)
            holder = ViewHolder()
            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

        return view
    }
}

class ViewHolder{
    var carName : TextView? = null
    var carEngine : TextView? = null
}