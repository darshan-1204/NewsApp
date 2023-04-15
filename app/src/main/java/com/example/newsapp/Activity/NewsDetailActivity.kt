package com.example.newsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {
    private val TAG = "NewsDetailActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var content = intent.getStringExtra("content")
        var img = intent.getStringExtra("img")
        var title = intent.getStringExtra("title")
        var url = intent.getStringExtra("link")

//        Log.e(TAG, "onCreate: ===" +content + img )
//        var data = MainActivity.data
//
        binding.descNd.setText(content.toString())
        binding.title.setText(title.toString())


        binding.btnUrl.setOnClickListener {


        }

        Glide.with(this).load(img).into(binding.imgNd)

        binding.back.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}