package com.example.newsapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.newsapp.Activity.NewsDetailActivity
import com.example.newsapp.ModelClass.ArticlesItem
import com.example.newsapp.R

class NewsAdapter(data: ArrayList<ArticlesItem>) : Adapter<NewsAdapter.NewsHolder>() {

    var data = data
    class NewsHolder(itemView: View) : ViewHolder(itemView){
        var txt = itemView.findViewById<TextView>(R.id.rcvText)
        var img = itemView.findViewById<ImageView>(R.id.rcvImg)
        var source = itemView.findViewById<TextView>(R.id.rcvSource)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {

        return NewsHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return data?.size!!
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {


        holder.txt.text = data?.get(position)?.title
//        holder.date.text = originalDate
        holder.source.text = data[position].source?.name.toString()

        Glide.with(holder.itemView.context).load(data?.get(position)?.urlToImage).into(holder.img)

        holder.itemView.setOnClickListener {

            var intent = Intent(holder.itemView.context,NewsDetailActivity::class.java)
            intent.putExtra("content", data[position].description)
            intent.putExtra("title", data[position].title)
            intent.putExtra("img", data[position].urlToImage)
            intent.putExtra("link", data[position].url)
            holder.itemView.context.startActivity(intent)
        }
    }
}