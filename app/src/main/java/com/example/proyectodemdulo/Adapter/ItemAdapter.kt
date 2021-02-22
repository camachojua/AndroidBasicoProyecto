package com.example.proyectodemdulo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodemdulo.R

class ItemAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ElementoViewHolder>(){

        inner class ElementoViewHolder(view: View): RecyclerView.ViewHolder(view) {
            var itemTextView: TextView = view.findViewById(R.id.item_view)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ElementoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ElementoViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemTextView.text = item
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}