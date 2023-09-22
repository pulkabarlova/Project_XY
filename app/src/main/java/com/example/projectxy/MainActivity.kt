package com.example.projectxy

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

private lateinit var song: MediaPlayer



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (getSupportActionBar() != null)
            getSupportActionBar()!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        song = MediaPlayer.create(this, R.raw.blood)
    }

    fun Play(mus: MediaPlayer) {
        song.start()
    }

    fun perehod(view: View) {
        Play(song)
        val second = Intent(this, MainActivity2::class.java)
        startActivity(second)
    }

    fun perehod2(view: View) {
        val third = Intent(this, About_us::class.java)
        startActivity(third)

    }

    fun perehod3(view: View) {
        val fouth = Intent(this, HEM_PROB::class.java)
        startActivity(fouth)
    }
    fun perehod4(view: View) {
        val fiveth = Intent(this, settings::class.java)
        startActivity(fiveth)
    }

}