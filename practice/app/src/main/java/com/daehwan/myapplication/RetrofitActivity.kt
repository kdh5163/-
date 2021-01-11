package com.daehwan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/") // 도메인 부분만
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)
        // GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>>{
            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful){
                    val personList = response.body()
                    val code = response.code()
                    val header = response.headers()
                    val error = response.errorBody()
                    Log.d("retrofitt",""+ error)
                    val retrofitRecycler = findViewById<RecyclerView>(R.id.recycler_person)
                    val adapter = RetrofitAdapter(personList!!,layoutInflater)
                    retrofitRecycler!!.adapter = adapter
                    retrofitRecycler!!.layoutManager = LinearLayoutManager(this@RetrofitActivity)
                }
            }

            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt","ERROR")
            }
        })
        // POST 요청1
//        val params = HashMap<String,Any>()
//        params.put("name","어렵다")
//        params.put("age",20)
//        params.put("intro","안녕하세요")
//        service.createStudent(params).enqueue(object : Callback<PersonFromServer>{
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if (response.isSuccessful){
//                    val person = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
        // POST 요청2
        val person = PersonFromServer(name = "우히히",age = 1,intro = "우헤헤")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer>{
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if (response.isSuccessful){
                    val person = response.body()
                }
            }

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}

class RetrofitAdapter(
    val personList : ArrayList<PersonFromServer>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<RetrofitAdapter.ViewHolder>(){
    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val name : TextView
        val age : TextView
        val intro : TextView
        init {
            name = itemView.findViewById(R.id.person_name)
            age = itemView.findViewById(R.id.person_age)
            intro = itemView.findViewById(R.id.person_ment)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.person_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList[position].name)
        holder.age.setText(personList[position].age.toString())
        holder.intro.setText(personList[position].intro)
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}