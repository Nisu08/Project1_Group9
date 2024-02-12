package com.example.project1_group9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class ProductActivity : AppCompatActivity() {

    private var adapter: ProductAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        Log.i("AAAAAAAAA","DOne")

        val query = FirebaseDatabase.getInstance().reference.child("products")
        val options = FirebaseRecyclerOptions.Builder<Product>().setQuery(query, Product::class.java).build()
        adapter = ProductAdapter(options)
        val rView : RecyclerView = findViewById(R.id.recView)
        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = adapter
    }
    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }

}