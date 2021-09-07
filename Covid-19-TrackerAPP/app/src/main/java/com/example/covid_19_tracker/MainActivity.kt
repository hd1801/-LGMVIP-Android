package com.example.covid_19_tracker

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }
    private fun getData(){
        val textView :TextView = findViewById(R.id.text_input1)
        val queue = Volley.newRequestQueue(this)
        val url = "https://data.covid19india.org/v4/min/data.min.json"
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                textView.text= response.toString()
                Toast.makeText(this,"api call success",Toast.LENGTH_LONG).show()
             },
            { error ->
                // TODO: Handle error
                Toast.makeText(this,"api call failure",Toast.LENGTH_LONG).show()
            }
        )
        queue.add(jsonObjectRequest)
    }
}