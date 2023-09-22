package com.example.projectxy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Itog_desease : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        setContentView(R.layout.activity_itog_desease)
        val intent = intent
        val hem_final_prob = intent.getStringExtra("Hem")
        val sickle_final_prob = intent.getStringExtra("Sickle")
        val hyp_final_peob = intent.getStringExtra("Hyp")
        val phen_final_prob = intent.getStringExtra("Phen")
        val dal_final_prob = intent.getStringExtra("Dal")
        val hem = findViewById<TextView>(R.id.Hem)
        hem.text = hem_final_prob
        val sickle = findViewById<TextView>(R.id.Sickle)
        sickle.text = sickle_final_prob
        val hyp = findViewById<TextView>(R.id.Hyp)
        hyp.text = hyp_final_peob
        val phen = findViewById<TextView>(R.id.Phen)
        phen.text = phen_final_prob
        val dal = findViewById<TextView>(R.id.Dal)
        dal.text = dal_final_prob
    }
}