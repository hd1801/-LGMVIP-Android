package com.example.covid_19_tracker

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {
    private val data = ArrayList<Model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }
    private fun getData(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://data.covid19india.org/v4/min/data.min.json"
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                response.keys().forEach { data.add(Model(response.getJSONObject(it.toString()),it.toString()))
                     }
                val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
                // this creates a vertical layout Manager
                recyclerview.layoutManager = LinearLayoutManager(this)

                // ArrayList of class ItemsViewModel
                val adapter = CovidListAdapter(data)
                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter
                Toast.makeText(this,"api call success",Toast.LENGTH_LONG).show()
             },
            { error ->
                    Log.d("error",error?.localizedMessage.toString())
                Toast.makeText(this,"api call failure",Toast.LENGTH_LONG).show()
            }
        )
        queue.add(jsonObjectRequest)
    }
}