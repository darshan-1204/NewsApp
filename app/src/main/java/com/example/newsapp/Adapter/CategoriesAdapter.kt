package com.example.newsapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapp.R

class CategoriesAdapter(cat: Array<String>) : Adapter<CategoriesAdapter.DataHolder>() {

    var cat = cat
    lateinit var categoryClickInterface :CategoryClickInterface

    class DataHolder(itemView: View) : ViewHolder(itemView){
        var tv = itemView.findViewById<TextView>(R.id.txtCategories)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        return DataHolder(LayoutInflater.from(parent.context).inflate(R.layout.categories_item,parent,false))
    }

    override fun getItemCount(): Int {
        return cat.size
    }

    interface CategoryClickInterface{
        fun onCategoryClick(position: Int){

        }
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.tv.setText(cat[position].toString())

        holder.itemView.setOnClickListener {
            categoryClickInterface.onCategoryClick(position)
        }
    }


}