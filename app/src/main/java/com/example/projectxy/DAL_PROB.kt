package com.example.projectxy

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DAL_PROB : View.OnClickListener, AppCompatActivity() {
    var dal_d: Int = 0
    var dal_m: Int = 0
    var dal_mn: Int = 0
    var dal_dn: Int = 0
    var dal_prob: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        setContentView(R.layout.activity_d_a_l__p_r_o_b)
        var dal_dad_yes = findViewById<CheckBox>(R.id.dal_dad_yes)
        dal_dad_yes.setOnClickListener(this)
        var dal_mom_yes = findViewById<CheckBox>(R.id.dal_mom_yes)
        dal_mom_yes.setOnClickListener(this)
        var dal_dad_no = findViewById<CheckBox>(R.id.dal_dad_no)
        dal_dad_no.setOnClickListener(this)
        var dal_mom_no = findViewById<CheckBox>(R.id.dal_mom_no)
        dal_mom_no.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        p0 as CheckBox
        var isChecked: Boolean = p0.isChecked
        when (p0.id) {
            R.id.dal_dad_yes -> if (isChecked) {
                dal_d += 1
            }
            R.id.dal_mom_yes -> if (isChecked) {
                dal_m += 1
            }
            R.id.dal_mom_no -> if (isChecked) {
                dal_mn += 1
            }
            R.id.dal_dad_no -> if (isChecked) {
                dal_dn += 1
            }
        }
        when {
            (dal_mn == 1 && dal_d == 1) -> {
                dal_prob =
                    "DALTONISM: Daughter is disease carrier 50% \n Daughter is not disease carrier 50% \n Healthy son 50% \n Sick son 50%"
                dal_d = 0
                dal_mn = 0
            }
            (dal_m == 1 && dal_dn == 1) -> {
                dal_prob =
                    "DALTONISM: Daughter is disease carrier 50% \n Daughter is not disease carrier 50% \n Healthy son 50% \n Sick son 50%"
                dal_m = 0
                dal_dn = 0
            }
            (dal_mn == 1 && dal_dn == 1) -> {
                dal_prob =
                    "DALTONISM: Healthy daughter 100% \n Sick daughter 0% \n Healthy son 50% \n Sick son 50%"
                dal_mn = 0
                dal_dn = 0
            }
            (dal_m == 1 && dal_d == 1) -> {
                dal_prob =
                    "DALTONISM: Daughter is disease carrier 50% \n Daughter is sick 50% \n Healthy son 50% \n Sick son 50%"
                dal_d = 0
                dal_m = 0
            }
        }
    }
    fun text_dal(view:View){
        var text_dal = findViewById<TextView>(R.id.TEXT_dal)
        text_dal.text = dal_prob
    }
}