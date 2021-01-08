package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 50){
            carList.add(CarForList(""+i+"번째 자동차",""+i+"순위 엔진"))
        }
        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity),this@RecyclerViewActivity)
        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
//        recycler_view.layoutManager = GridLayoutManager(this@RecyclerViewActivity,2)
    }
}

class RecyclerViewAdapter(
    val carList: ArrayList<CarForList>,
    val inflater: LayoutInflater,
    val context: RecyclerViewActivity
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){ //inner를 붙여주어야 outer 클래스의 변수를 사용할 수 있음
        val carName : TextView
        val carEngine : TextView
        init {
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)
            itemView.setOnClickListener {
                val position = adapterPosition // 포지션을 가져옴
                val engineName = carList.get(position).engine
                Toast.makeText(context,engineName,Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(carList.get(position).name)
        holder.carEngine.setText(carList.get(position).engine)
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}