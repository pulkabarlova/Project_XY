package com.example.projectxy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
    fun perehod0(view: View) {
        val second = Intent(this, MainActivity::class.java)
        startActivity(second)
    }
}