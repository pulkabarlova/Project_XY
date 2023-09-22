package com.example.projectxy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PHEN_PROB : View.OnClickListener, AppCompatActivity() {
    var phen_d: Int = 0
    var phen_m: Int = 0
    var phen_dn: Int = 0
    var phen_mn: Int = 0
    var phen_prob: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        setContentView(R.layout.activity_p_h_e_n__p_r_o_b)
        var phen_dad_yes = findViewById<CheckBox>(R.id.phen_dad_yes)
        phen_dad_yes.setOnClickListener(this)
        var phen_mom_yes = findViewById<CheckBox>(R.id.phen_mom_yes)
        phen_mom_yes.setOnClickListener(this)
        var phen_dad_no = findViewById<CheckBox>(R.id.phen_dad_no)
        phen_dad_no.setOnClickListener(this)
        var phen_mom_no = findViewById<CheckBox>(R.id.phen_mom_no)
        phen_mom_no.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        p0 as CheckBox
        var isChecked: Boolean = p0.isChecked
        when (p0.id) {
            R.id.phen_dad_yes -> if (isChecked) {
                phen_d += 1
            }
            R.id.phen_mom_yes -> if (isChecked) {
                phen_m += 1
            }
            R.id.phen_mom_no -> if (isChecked) {
                phen_mn += 1
            }
            R.id.phen_dad_no -> if (isChecked) {
                phen_dn += 1
            }
        }
        when {
            ((phen_dn == 1 && phen_m == 1) or (phen_d == 1 && phen_mn == 1)) -> {
                phen_prob =
                    "PHENYLKETONURIA: Healthy daughter 50% \n Sick daughter 50% \n Healthy son 50% \n Sick son 50%"
                phen_d = 0
                phen_m = 0
                phen_dn = 0
                phen_mn = 0
            }
            (phen_dn == 1 && phen_mn == 1) -> {
                phen_prob =
                    "PHENYLKETONURIA: Healthy daughter 75% \n Sick daughter 25% \n Healthy son 75% \n Sick son 25%"
                phen_dn = 0
                phen_mn = 0
            }
            (phen_d == 1 && phen_m == 1) -> {
                phen_prob =
                    "PHENYLKETONURIA: Healthy daughter 25% \n Sick daughter 75% \n Healthy son 25% \n Sick son 75%"
                phen_d = 0
                phen_m = 0
            }
        }

    }

    fun text_phen(view: View) {
        var text_phen = findViewById<TextView>(R.id.TEXT_phen)
        text_phen.text = phen_prob
    }

    fun to_dal(view: View) {
        val next = Intent(this, DAL_PROB::class.java)
        startActivity(next)
    }
}