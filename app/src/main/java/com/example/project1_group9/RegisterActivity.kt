package com.example.project1_group9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var registerMail = findViewById<EditText>(R.id.registerMail)
        var registerPassword = findViewById<EditText>(R.id.registerPassword)
        var registerBtn = findViewById<Button>(R.id.registerBtn)
        var txtlogin = findViewById<TextView>(R.id.txtlogin)

        txtlogin.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }

        registerBtn.setOnClickListener {
            val mail= registerMail.text.toString()
            val pass= registerPassword.text.toString()

            if(mail.isNotEmpty() && pass.isNotEmpty()){
                auth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        startActivity(Intent(this, ProductActivity::class.java))
                        finish()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}