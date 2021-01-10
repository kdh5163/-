package com.daehwan.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        NetworkTask().execute()
    }
}

class NetworkTask():AsyncTask<Any?,Any?,Any?>(){
    override fun doInBackground(vararg params: Any?): Any? {
        val urlString = "http://mellowcode.org/json/students/"
        val url = URL(urlString)
        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type","application/json")
        Log.d("connn","inputstream : "+connection.inputStream)
        var buffer = ""
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            Log.d("connn","inputstream : "+ connection.inputStream)
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
            Log.d("connn","inputstream : "+ buffer)
        }


        return null
    }
}