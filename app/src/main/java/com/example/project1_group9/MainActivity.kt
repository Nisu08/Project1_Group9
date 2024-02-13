package com.example.project1_group9

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtContinue: TextView = findViewById<TextView>(R.id.txtContinue)
        val imgBtn: ImageButton = findViewById<ImageButton>(R.id.imgBtn)

        imgBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, SignInActivity::class.java))
        }
        txtContinue.setOnClickListener {
            startActivity(Intent(this@MainActivity, SignInActivity::class.java))
        }
    }
}