package com.example.projectxy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var intent = intent
        val grop = intent.getStringExtra("Group")
        val prob = intent.getStringExtra("Prob")
        var tt = findViewById<TextView>(R.id.text2)
        tt.text = grop + " " + prob + " "

    }

}