package com.example.project1_group9

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt1 = findViewById<TextView>(R.id.txt1)
        val imgbtn = findViewById<ImageButton>(R.id.imgbtn)

        imgbtn.setOnClickListener {view ->
            startActivity(Intent(this@MainActivity, ProductActivity::class.java))
        }
        txt1.setOnClickListener{view->
            startActivity(Intent(this@MainActivity, ProductActivity::class.java))
        }
    }
}