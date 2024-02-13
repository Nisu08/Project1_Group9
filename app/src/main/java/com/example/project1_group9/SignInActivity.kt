package com.example.project1_group9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
class SignInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onStart() {
        super.onStart()
        val currUser = auth.currentUser
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_sign_in)

        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            // User is already logged in, redirect to ProductActivity
            startActivity(Intent(this, ProductActivity::class.java))
            finish()
        }

        var signinMail = findViewById<EditText>(R.id.signinMail)
        var signinPassword = findViewById<EditText>(R.id.signinPassword)
        var signinBtn = findViewById<Button>(R.id.signinBtn)
        var txtregister = findViewById<TextView>(R.id.txtregister)

        txtregister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        signinBtn.setOnClickListener {
            val mail= signinMail.text.toString()
            val pass= signinPassword.text.toString()

            if(mail.isNotEmpty() && pass.isNotEmpty()){
                auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener{
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