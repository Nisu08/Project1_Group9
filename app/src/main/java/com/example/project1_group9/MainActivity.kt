package com.example.project1_group9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, ProductActivity::class.java)
        startActivity(intent)

        // Finish MainActivity to prevent going back to it when pressing back button
        finish()
    }
}