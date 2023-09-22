package com.example.projectxy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    var cm1: Int = 0
    var cd1: Int = 0
    var cm2: Int = 0
    var cd2: Int = 0
    var cm3: Int = 0
    var cd3: Int = 0
    var cm4: Int = 0
    var cd4: Int = 0
    var final_group: String? = null
    var final_prob: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var momfirstyes = findViewById<CheckBox>(R.id.momfirstyes)
        momfirstyes.setOnClickListener(this)
        var dadfirstyes = findViewById<CheckBox>(R.id.dadfirstyes)
        dadfirstyes.setOnClickListener(this)
        var momsecondyes = findViewById<CheckBox>(R.id.momsecondyes)
        momsecondyes.setOnClickListener(this)
        var dadsecondyes = findViewById<CheckBox>(R.id.dadsecondyes)
        dadsecondyes.setOnClickListener(this)
        var momthirdyes = findViewById<CheckBox>(R.id.momthirdyes)
        momthirdyes.setOnClickListener(this)
        var dadthirdyes = findViewById<CheckBox>(R.id.dadthirdyes)
        dadthirdyes.setOnClickListener(this)
        var momfouryes = findViewById<CheckBox>(R.id.momfouryes)
        momfouryes.setOnClickListener(this)
        var dadfouryes = findViewById<CheckBox>(R.id.dadfouryes)
        dadfouryes.setOnClickListener(this)


    }

    fun bac(view: View) {
        val second = Intent(this, MainActivity::class.java)
        startActivity(second)
    }

    fun vper(view: View) {
        val second = Intent(this, MainActivit::class.java)
        startActivity(second)
    }

    override fun onClick(p0: View?) {
        p0 as CheckBox
        var isChecked: Boolean = p0.isChecked
        when (p0.id) {
            R.id.momfirstyes -> if (isChecked) {
                cm1 += 1
            }
            R.id.dadfirstyes -> if (isChecked) {
                cd1 += 1
            }
            R.id.momsecondyes -> if (isChecked) {
                cm2 += 1
            }
            R.id.dadsecondyes -> if (isChecked) {
                cd2 += 1
            }
            R.id.momthirdyes -> if (isChecked) {
                cm3 += 1
            }
            R.id.dadthirdyes -> if (isChecked) {
                cd3 += 1
            }
            R.id.momfouryes -> if (isChecked) {
                cm4 += 1
            }
            R.id.dadfouryes -> if (isChecked) {
                cd4 += 1
            }
        }
        when {
            (cm2 + cd1 == 2) -> {
                final_group = "I or II"
                final_prob = "50 / 50"
                cm2 = 0
                cd1 = 0
            }
            (cm1 + cd1 == 2) -> {
                final_group = "I"
                final_prob = "100%"
                cm1 = 0
                cd1 = 0
            }
            (cm1 + cd2 == 2) or (cm2 + cd1 == 2) -> {
                final_group = "I or II"
                final_prob = "50 / 50"
                cm1 = 0
                cd2 = 0
            }
            (cm1 + cd3 == 2) or (cm3 + cd1 == 2) -> {
                final_group = "I or III"
                final_prob = "50 / 50"
                cm1 = 0
                cd3 = 0
            }
            (cm1 + cd4 == 2) or (cm4 + cd1 == 2) -> {
                final_group = "II or III"
                final_prob = "50 / 50"
                cm1 = 0
                cd4 = 0
            }
            (cm2 + cd2 == 2) or (cm2 + cd2 == 2) -> {
                final_group = "I or II"
                final_prob = "25 / 75"
                cm2 = 0
                cd2 = 0
            }
            (cm2 + cd3 == 2) or (cm3 + cd2 == 2) -> {
                final_group = "I or II or III or IV"
                final_prob = "25 / 25 / 25 / 25"
                cm2 = 0
                cd3 = 0
            }
            (cm2 + cd4 == 2) or (cm4 + cd2 == 2) -> {
                final_group = "II or III or IV"
                final_prob = "50 / 25 / 25"
                cm2 = 0
                cd4 = 0
            }
            (cm3 + cd3 == 2) or (cm3 + cd3 == 2) -> {
                final_group = "II or III or IV"
                final_prob = "25 / 75"
                cm3 = 0
                cd3 = 0
            }
            (cm3 + cd4 == 2) or (cm4 + cd3 == 2) -> {
                final_group = "I or III or IV"
                final_prob = "25 / 50 / 25"
                cm3 = 0
                cd4 = 0
            }
            (cm4 + cd4 == 2) or (cm4 + cd4 == 2) -> {
                final_group = "II or III or IV"
                final_prob = "25 / 25 / 50"
                cm4 = 0
                cd4 = 0
            }
        }

        val butper = findViewById<ImageView>(R.id.next)
        butper.setOnClickListener {
            val grop = final_group
            val prob = final_prob

            val intent = Intent(this@MainActivity2, MainActivit::class.java)
            intent.putExtra("Group", grop)
            intent.putExtra("Prob", prob)

            startActivity(intent)
        }

    }

}