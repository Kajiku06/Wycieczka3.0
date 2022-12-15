package com.mateusz.wycieczka

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<Button>(R.id.button3).setOnClickListener{
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
            finish()

        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        return true


    }


    override fun onOptionsItemSelected(items: MenuItem): Boolean {

        return when (items.itemId) {
            R.id.exit -> {
                finish()
                true
            }
            R.id.czcionka -> {
                true
            }
            else -> super.onOptionsItemSelected(items)
        }

    }



}