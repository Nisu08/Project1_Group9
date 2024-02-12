package com.example.project1_group9

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ProductAdapter(options: FirebaseRecyclerOptions<Product>) :
    FirebaseRecyclerAdapter<Product, ProductAdapter.MyViewHolder>(options) {
    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.product_row_layout, parent, false)) {
        val imgProduct: ImageView = itemView.findViewById(R.id.imgProduct)
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtManufacturer: TextView = itemView.findViewById(R.id.manuPdt)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
        val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
        val cardView: CardView = itemView.findViewById(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Product) {

        holder.txtName.text = model.name
        holder.txtManufacturer.text = model.manufacturer
        holder.txtPrice.text = model.price.toString()
        holder.txtDescription.text = model.description

        val storageRef: StorageReference =
            FirebaseStorage.getInstance().getReferenceFromUrl(model.url)
        Glide.with(holder.imgProduct.context).load(storageRef).into(holder.imgProduct)

        holder.cardView.setOnClickListener { view ->
            val intent = Intent(
                view.context,
                DetailActivity::class.java
            )
            intent.putExtra("productDetails", model)
            view.context.startActivity(intent)
        }
    }
}