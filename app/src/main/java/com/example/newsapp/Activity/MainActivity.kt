package com.example.newsapp.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.Adapter.NewsAdapter
import com.example.newsapp.Api.ApiClient
import com.example.newsapp.Api.ApiInterface
import com.example.newsapp.ArticlesItem
import com.example.newsapp.NewsModel
import com.example.newsapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.sports.setOnClickListener {
            loadNews("sport")
        }
        binding.technology.setOnClickListener {
            loadNews("technology")

        }
        binding.business.setOnClickListener {
            loadNews("business")
        }
        binding.health.setOnClickListener {
            loadNews("health")
        }
        binding.general.setOnClickListener {
            loadNews("general")
        }
        binding.science.setOnClickListener {
            loadNews("science")
        }
        binding.entertainment.setOnClickListener {
            loadNews("entertainment")
        }

        loadNews()
    }


    fun loadNews() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", "general", "a5a506de67624ea9b09b1ebea7e547b4")
            .enqueue(object : Callback<NewsModel> {
                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {

                    var data = response.body()

//                Log.e(TAG, "onResponse: ========" + data )

                    binding.recycler.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.recycler.adapter =
                        NewsAdapter(data?.articles as ArrayList<ArticlesItem>)
                }

                override fun onFailure(call: Call<NewsModel>, t: Throwable) {

                    Log.e(TAG, "onFailure: ===" + t.message)
                }

            })
    }

    fun loadNews(text : String){

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", text, "a5a506de67624ea9b09b1ebea7e547b4")
            .enqueue(object : Callback<NewsModel> {
                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {

                    var data = response.body()

//                Log.e(TAG, "onResponse: ========" + data )

                    binding.recycler.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.recycler.adapter =
                        NewsAdapter(data?.articles as ArrayList<ArticlesItem>)
                }

                override fun onFailure(call: Call<NewsModel>, t: Throwable) {

                    Log.e(TAG, "onFailure: ===" + t.message)
                }

            })

    }










}