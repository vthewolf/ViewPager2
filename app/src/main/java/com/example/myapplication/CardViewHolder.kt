package com.example.myapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val qr: ImageView = view.findViewById(R.id.qr)
    private val name: TextView = view.findViewById(R.id.childrenName)

    fun bind(customer: Customer) {
        name.text = customer.name

        Glide.with(itemView.context).load(customer.imageUrl).into(qr)
    }

}
