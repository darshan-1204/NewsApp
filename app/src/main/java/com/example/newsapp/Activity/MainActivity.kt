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
    var cat =
        arrayOf("Sports", "Technology", "Business", "Health", "General", "Science", "Entertainment")

    //        companion object{
//        lateinit var data : ArrayList<ArticlesItem>
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.sports.setOnClickListener {
            loadSportNews()
        }
        binding.technology.setOnClickListener {
            loadTechNews()
        }
        binding.business.setOnClickListener {
            loadBusinessNews()
        }
        binding.health.setOnClickListener {
            loadHealthNews()
        }
        binding.general.setOnClickListener {
            loadGeneralNews()
        }
        binding.science.setOnClickListener {
            loadScienceNews()
        }
        binding.entertainment.setOnClickListener {
            loadEntertainmentNews()
        }

        loadNews()
    }


    fun loadNews() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", "business", "a5a506de67624ea9b09b1ebea7e547b4")
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

    fun loadSportNews() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", "sport", "a5a506de67624ea9b09b1ebea7e547b4")
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

    fun loadTechNews() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", "technology", "a5a506de67624ea9b09b1ebea7e547b4")
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

    fun loadBusinessNews() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", "business", "a5a506de67624ea9b09b1ebea7e547b4")
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

    fun loadHealthNews() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", "health", "a5a506de67624ea9b09b1ebea7e547b4")
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

    fun loadGeneralNews() {

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

    fun loadScienceNews() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", "science", "a5a506de67624ea9b09b1ebea7e547b4")
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

    fun loadEntertainmentNews() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", "entertainment", "a5a506de67624ea9b09b1ebea7e547b4")
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


