package com.example.projectxy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HYP_PROB : View.OnClickListener, AppCompatActivity() {
    var hyp_d: Int = 0
    var hyp_dn: Int = 0
    var hyp_prob: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        setContentView(R.layout.activity_h_y_p__p_r_o_b)
        var hyp_dad_yes = findViewById<CheckBox>(R.id.hyp_dad_yes)
        hyp_dad_yes.setOnClickListener(this)
        var hyp_dad_no = findViewById<CheckBox>(R.id.hyp_dad_no)
        hyp_dad_no.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        p0 as CheckBox
        var isChecked: Boolean = p0.isChecked
        when (p0.id) {
            R.id.hyp_dad_yes -> if (isChecked) {
                hyp_d += 1
            }
            R.id.hyp_dad_no -> if (isChecked) {
                hyp_dn += 1
            }
        }
        when {
            (hyp_d == 1) -> {
                hyp_prob =
                    "HYPERTRICHOSIS: Healthy daughter 100% \n Sick daughter 0% \n Healthy son 0% \n Sick son 100%"
                hyp_d = 0
            }
            (hyp_dn == 1) -> {
                hyp_prob =
                    "HYPERTRICHOSIS: Healthy daughter 100% \n Sick daughter 0% \n Healthy son 100% \n Sick son 0%"
                hyp_dn = 0
            }

        }
    }

    fun text_hyp(view: View) {
        var text_hyp = findViewById<TextView>(R.id.TEXT_hyp)
        text_hyp.text = hyp_prob
    }

    fun to_phen(view: View) {
        val next = Intent(this, PHEN_PROB::class.java)
        startActivity(next)
    }
}

