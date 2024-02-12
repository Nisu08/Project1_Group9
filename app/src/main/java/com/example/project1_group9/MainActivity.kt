package com.example.project1_group9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt1 = findViewById<TextView>(R.id.txt1)
        val imgbtn = findViewById<ImageButton>(R.id.imgbtn)

        imgbtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, ProductActivity::class.java))
        }
        txt1.setOnClickListener{
            startActivity(Intent(this@MainActivity, ProductActivity::class.java))
        }
    }
}