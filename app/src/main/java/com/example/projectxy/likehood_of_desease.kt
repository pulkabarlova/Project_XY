package com.example.projectxy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class likehood_of_desease : View.OnClickListener, AppCompatActivity() {
    var counter: Int = 0
    var hem_m: Int = 0
    var hem_d: Int = 0
    var sickle_m: Int = 0
    var sickle_d: Int = 0
    var hyp_m: Int = 0
    var hyp_d: Int = 0
    var phen_m: Int = 0
    var phen_d: Int = 0
    var dal_m: Int = 0
    var dal_d: Int = 0
    var hem_prob: String? = null
    var sickle_prob: String? = null
    var hyp_prob: String? = null
    var phen_prob: String? = null
    var dal_prob: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_likehood_of_desease)
        var hem_dad = findViewById<CheckBox>(R.id.hem_dad)
        hem_dad.setOnClickListener(this)
        var sickle_mom = findViewById<CheckBox>(R.id.sickle_mom)
        sickle_mom.setOnClickListener(this)
        var sickle_dad = findViewById<CheckBox>(R.id.sickle_dad)
        sickle_dad.setOnClickListener(this)
        var hyp_dad = findViewById<CheckBox>(R.id.hyp_dad)
        hyp_dad.setOnClickListener(this)
        var phen_mom = findViewById<CheckBox>(R.id.phen_mom)
        phen_mom.setOnClickListener(this)
        var phen_dad = findViewById<CheckBox>(R.id.phen_dad)
        phen_dad.setOnClickListener(this)
        var dal_mom = findViewById<CheckBox>(R.id.dal_mom)
        dal_mom.setOnClickListener(this)
        var dal_dad = findViewById<CheckBox>(R.id.dal_dad)
        dal_dad.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        p0 as CheckBox
        var isChecked: Boolean = p0.isChecked
        when (p0.id) {
            R.id.hem_dad -> if (isChecked) {
                hem_d += 1
            }
            R.id.sickle_mom -> if (isChecked) {
                sickle_m += 1
            }
            R.id.sickle_dad -> if (isChecked) {
                sickle_d += 1
            }
            R.id.hyp_dad -> if (isChecked) {
                hyp_d += 1
            }
            R.id.phen_mom -> if (isChecked) {
                phen_m += 1
            }
            R.id.phen_dad -> if (isChecked) {
                phen_d += 1
            }
            R.id.dal_mom -> if (isChecked) {
                dal_m += 1
            }
            R.id.dal_dad -> if (isChecked) {
                dal_d += 1
            }

        }
        when {
            (hem_m == 0 && hem_d == 1) -> {
                hem_prob =
                    "HEMOPHILIA: Healthy daughter 50% \n/ Daughter may not be born 50% \n Healthy son 50% / Sick son 50%"
                hem_d = 0
            }
            (hem_m == 0 && hem_d == 0) -> {
                hem_prob =
                    "HEMOPHILIA: Healthy daughter 100% \n/ Sick daughter 0% \n Healthy son 50% / Sick son 50%"
            }
        }
        when {
            (dal_m == 0 && dal_d == 1) -> {
                dal_prob =
                    "DALTONISM: Daughter is disease carrier 50% \n/ Daughter is not disease carrier 50% \n Healthy son 50% / Sick son 50%"
                dal_d = 0
            }
            (dal_m == 1 && dal_d == 0) -> {
                dal_prob =
                    "DALTONISM: Daughter is disease carrier 50% \n/ Daughter is not disease carrier 50% \n Healthy son 50% / Sick son 50%"
                dal_m = 0
            }
            (dal_m == 0 && dal_d == 0) -> {
                dal_prob =
                    "DALTONISM: Healthy daughter 100% \n/ Sick daughter 0% \n Healthy son 50% / Sick son 50%"
            }
        }
        when {
            ((phen_d == 0 && phen_m == 1) or (phen_d == 1 && phen_m == 0)) -> {
                phen_prob =
                    "PHENYLKETONURIA: Healthy daughter 50% \n/ Sick daughter 50% \n Healthy son 50% / Sick son 50%"
                phen_d = 0
                phen_m = 0
            }
            (phen_d == 0 && phen_m == 0) -> {
                phen_prob =
                    "PHENYLKETONURIA: Healthy daughter 75% \n/ Sick daughter 25% \n Healthy son 75% / Sick son 25%"
            }
            (phen_d == 1 && phen_m == 1) -> {
                phen_prob =
                    "PHENYLKETONURIA: Healthy daughter 25% \n/ Sick daughter 75% \n Healthy son 25% / Sick son 75%"
                phen_d = 0
                phen_m = 0
            }
        }
        when {
            ((sickle_d == 1 && sickle_m == 0) or (sickle_d == 0 && sickle_m == 1)) -> {
                sickle_prob =
                    "SICKLE CELL ANEMIA: Healthy daughter 50% \n/ Sick daughter 50% \n Healthy son 50% / Sick son 50%"
                sickle_d = 0
                sickle_m = 0

            }
            (sickle_d == 0 && sickle_m == 0) -> {
                sickle_prob =
                    "SICKLE CELL ANEMIA: Healthy daughter 75% \n/ Sick daughter 25% \n Healthy son 75% / Sick son 25%"
            }
            (sickle_d == 1 && sickle_m == 1) -> {
                sickle_prob =
                    "SICKLE CELL ANEMIA: Healthy daughter 25% \n/ Sick daughter 75% \n Healthy son 25% / Sick son 75%"
                sickle_d = 0
                sickle_m = 0
            }
        }
        when {
            (hyp_d == 1 && hyp_m == 0) -> {
                hyp_prob =
                    "HYPERTRICHOSIS: Healthy daughter 100% \n/ Sick daughter 0% \n Healthy son 0% / Sick son 100%"
                hyp_d = 0
            }
            (hyp_d == 0 && hyp_m == 0) -> {
                hyp_prob =
                    "HYPERTRICHOSIS: Healthy daughter 100% \n/ Sick daughter 0% \n Healthy son 100% / Sick son 0%"
            }

        }
        val main_perehod = findViewById<ImageView>(R.id.nextt)
        main_perehod.setOnClickListener {
            val hem_final_prob = hem_prob
            val dal_final_prob = dal_prob
            val phen_final_prob = phen_prob
            val hyp_final_prob = hyp_prob
            val sickle_final_prob = sickle_prob
            val intent = Intent(this@likehood_of_desease, Itog_desease::class.java)
            intent.putExtra("Hem", hem_final_prob)
            intent.putExtra("Sickle", sickle_final_prob)
            intent.putExtra("Hyp", hyp_final_prob)
            intent.putExtra("Phen", phen_final_prob)
            intent.putExtra("Dal", dal_final_prob)
            startActivity(intent)
        }
        val perehod_on_hem = findViewById<ImageView>(R.id.hemm)
        perehod_on_hem.setOnClickListener {
            val hem_final_probb = hem_prob
            val intent = Intent(this@likehood_of_desease, HEM_PROB::class.java)
            intent.putExtra("Hemm", hem_final_probb)
            startActivity(intent)
        }
        val perehod_on_sickle = findViewById<ImageView>(R.id.hemm)
        perehod_on_hem.setOnClickListener {
            val sickle_final_probb = sickle_prob
            val intent = Intent(this@likehood_of_desease, SICKLE_PROB::class.java)
            intent.putExtra("Sicklee", sickle_final_probb)
            startActivity(intent)
        }


    }


    fun mainperehod(view: View) {
        val next = Intent(this, Itog_desease::class.java)
        startActivity(next)
    }

    fun onhem(view: View) {
        val next = Intent(this, HEM_PROB::class.java)
        startActivity(next)
    }

    fun onsickle(view: View) {
        val next = Intent(this, SICKLE_PROB::class.java)
        startActivity(next)
    }


}


