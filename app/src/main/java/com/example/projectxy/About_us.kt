package com.example.projectxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class About_us : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        layoutManager = LinearLayoutManager(this)
        var recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = layoutManager
        adapter = RecyclerViewAdaptor()
        recyclerview.adapter = adapter
    }
}