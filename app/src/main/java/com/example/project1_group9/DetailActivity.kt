package com.example.project1_group9

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val product = intent.getSerializableExtra("productDetails") as Product

        val txtName: TextView = findViewById(R.id.txtName)
        txtName.text = product.name

        val txtDescription: TextView = findViewById(R.id.txtDescription)
        txtDescription.text = product.description

        val txtPrice: TextView = findViewById(R.id.txtPrice)
        txtPrice.text = "$ " + product.price

        val txtManufacturer: TextView = findViewById(R.id.txtManufacturer)
        txtManufacturer.text = "Sold By: " + product.manufacturer

        val txtFullDescription: TextView = findViewById(R.id.txtFullDescription)
        txtFullDescription.text = product.fullDescription

        val storageRef: StorageReference =
            FirebaseStorage.getInstance().getReferenceFromUrl(product.url)
        Glide.with(this).load(storageRef).into(findViewById(R.id.imgProduct))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_logout) {
            Toast.makeText(this, "User Logged Out", Toast.LENGTH_LONG).show()
            FirebaseAuth.getInstance().signOut()
            val homeIntent = Intent(this, SignInActivity::class.java)
            startActivity(homeIntent)
            finish()
        } else if (item.itemId == R.id.nav_home) {
            val mainIntent = Intent(this, ProductActivity::class.java)
            startActivity(mainIntent)
        } else if (item.itemId == R.id.nav_cart) {
            val cartIntent = Intent(this, CartActivity::class.java)
            startActivity(cartIntent)
        }
        return true
    }
}