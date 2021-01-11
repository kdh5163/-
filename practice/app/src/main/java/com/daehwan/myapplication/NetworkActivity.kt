package com.daehwan.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        val task = NetworkTask(findViewById(R.id.recycler_person),layoutInflater,this@NetworkActivity).execute()

    }
}

class NetworkTask(
    val recyclerView: RecyclerView,
    val inflater: LayoutInflater,
    val context: NetworkActivity
):AsyncTask<Any?,Any?,Array<PersonFromServer>>(){
    override fun doInBackground(vararg params: Any?): Array<PersonFromServer>? {
        val urlString = "http://mellowcode.org/json/students/"
        val url = URL(urlString)
        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type","application/json")
        var buffer = ""
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
        }
        val data = Gson().fromJson(buffer,Array<PersonFromServer>::class.java)

        return data
    }

    override fun onPostExecute(result: Array<PersonFromServer>) {
        val adapter = PersonAdapter(result,inflater)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }
}

class PersonAdapter(
    val personList: Array<PersonFromServer>,
    val inflater: LayoutInflater,
) : RecyclerView.Adapter<PersonAdapter.ViewHolder>(){
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
        holder.name.setText(personList.get(position).name)
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro)
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}