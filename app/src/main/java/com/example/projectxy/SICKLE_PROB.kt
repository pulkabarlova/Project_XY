package com.example.projectxy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SICKLE_PROB : View.OnClickListener, AppCompatActivity() {
    var sickle_m: Int = 0
    var sickle_d: Int = 0
    var sickle_mn: Int = 0
    var sickle_dn: Int = 0

    var sickle_prob: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_i_c_k_l_e__p_r_o_b)
        var sickle_mom = findViewById<CheckBox>(R.id.sickle_mom_yes)
        sickle_mom.setOnClickListener(this)
        var sickle_dad = findViewById<CheckBox>(R.id.sickle_dad_yes)
        sickle_dad.setOnClickListener(this)
        var sickle_mom_no = findViewById<CheckBox>(R.id.sickle_mom_no)
        sickle_mom_no.setOnClickListener(this)
        var sickle_dad_no = findViewById<CheckBox>(R.id.sickle_dad_no)
        sickle_dad_no.setOnClickListener(this)


    }
    override fun onClick(p0: View?) {
        p0 as CheckBox
        var isChecked: Boolean = p0.isChecked
        when (p0.id) {
            R.id.sickle_dad_yes -> if (isChecked) {
                sickle_d += 1
            }
            R.id.sickle_mom_yes -> if(isChecked){
                sickle_m += 1
            }
            R.id.sickle_dad_no -> if (isChecked) {
                sickle_dn += 1
            }
            R.id.sickle_mom_no -> if(isChecked){
                sickle_mn += 1
            }
        }
        when {
            ((sickle_d == 1 && sickle_mn == 1) or (sickle_dn == 1 && sickle_m == 1)) -> {
                sickle_prob =
                    "SICKLE CELL ANEMIA: Healthy daughter 50% \n Sick daughter 50% \n Healthy son 50% \n Sick son 50%"
                sickle_d = 0
                sickle_m = 0
                sickle_dn = 0
                sickle_mn = 0


            }
            (sickle_dn == 1 && sickle_mn == 1) -> {
                sickle_prob =
                    "SICKLE CELL ANEMIA: Healthy daughter 75% \n Sick daughter 25% \n Healthy son 75% \n Sick son 25%"
                sickle_dn = 0
                sickle_mn = 0
            }
            (sickle_d == 1 && sickle_m == 1) -> {
                sickle_prob =
                    "SICKLE CELL ANEMIA: Healthy daughter 25% \n Sick daughter 75% \n Healthy son 25% \n Sick son 75%"
                sickle_d = 0
                sickle_m = 0
            }
        }
}
    fun text(view: View){
        var text_sickle = findViewById<TextView>(R.id.TEXT_sickle)
        text_sickle.text = sickle_prob
    }
    fun to_hyp(view: View) {
        val next = Intent(this, HYP_PROB::class.java)
        startActivity(next)
    }
}