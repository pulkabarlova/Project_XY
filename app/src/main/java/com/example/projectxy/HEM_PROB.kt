package com.example.projectxy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HEM_PROB : View.OnClickListener, AppCompatActivity() {
    var hem_d: Int = 0
    var hem_dn: Int = 0
    var hem_prob: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_h_e_m__p_r_o_b)
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        var hem_dad = findViewById<CheckBox>(R.id.yes_dady)
        hem_dad.setOnClickListener(this)
        var hem_dadn = findViewById<CheckBox>(R.id.no_dady)
        hem_dadn.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        p0 as CheckBox
        var isChecked: Boolean = p0.isChecked
        when (p0.id) {
            R.id.yes_dady -> if (isChecked) {
                hem_d += 1
            }
            R.id.no_dady -> if (isChecked) {
                hem_dn += 1
            }

        }


        when {
            (hem_d == 1) -> {
                hem_prob =
                    "HEMOPHILIA: Healthy daughter 50% \n Daughter may not be born 50% \n Healthy son 50% \n Sick son 50%"
                hem_d = 0
            }
            (hem_dn == 1) -> {
                hem_prob =
                    "HEMOPHILIA: Healthy daughter 100% \n Sick daughter 0% \n Healthy son 50% \n Sick son 50%"
                hem_dn = 0
            }
        }
    }
    fun text(view: View){
        var text_hem = findViewById<TextView>(R.id.result_hem)
        text_hem.text = hem_prob
    }
    fun to_sickle(view: View) {
        val next = Intent(this, SICKLE_PROB::class.java)
        startActivity(next)
    }
    fun to_main(view: View) {
        val next = Intent(this, MainActivity::class.java)
        startActivity(next)
    }
}

