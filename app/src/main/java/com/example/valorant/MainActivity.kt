package com.example.valorant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the buttons

        val skyekabtn = findViewById<Button>(R.id.skyebtn)
        val kayokabtn : Button = findViewById(R.id.kayobtn)
        val breachkabtn : Button = findViewById(R.id.breachbtn)

        // Set click listeners for the buttons

        skyekabtn.setOnClickListener {
            val a = Intent(this@MainActivity, skye::class.java)
            startActivity(a)
        }
        kayokabtn.setOnClickListener {
            val b = Intent(this@MainActivity, kayo::class.java)
            startActivity(b)
        }
        breachkabtn.setOnClickListener {
            val c = Intent(this@MainActivity, breach::class.java)
            startActivity(c)
        }
    }
}
