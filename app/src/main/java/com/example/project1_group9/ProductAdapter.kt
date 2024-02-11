package com.example.project1_group9

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ProductAdapter(options: FirebaseRecyclerOptions<product>):
    FirebaseRecyclerAdapter<product, ProductAdapter.MyViewHolder>(options)
{
    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.product_rowlayout,parent,false))
    {
        val imgPdt: ImageView = itemView.findViewById(R.id.imgPdt)
        val namePdt: TextView = itemView.findViewById(R.id.namePdt)
        val manuPdt: TextView = itemView.findViewById(R.id.manuPdt)
        val pricePdt: TextView = itemView.findViewById(R.id.pricePdt)
        val descPdt: TextView = itemView.findViewById(R.id.descPdt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return  MyViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: product) {
        val name = model.name
        val manu = model.manufacturer
        val price = model.price
        val desc = model.description

        Log.d("ProductAdapter", "Product: $name, Manufacturer: $manu, Price: $price, Description: $desc")

        holder.namePdt.text = name
        holder.manuPdt.text = manu
        holder.pricePdt.text = price.toString()
        holder.descPdt.text = desc

        val StorageRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.url)
        Glide.with(holder.imgPdt.context).load(StorageRef).into(holder.imgPdt)

    }

}