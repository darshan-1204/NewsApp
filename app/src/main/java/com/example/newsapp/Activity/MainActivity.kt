package com.example.newsapp.Activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.Adapter.BreakingNewsAdapter
import com.example.newsapp.Adapter.NewsAdapter
import com.example.newsapp.Api.ApiClient
import com.example.newsapp.Api.ApiInterface
import com.example.newsapp.ModelClass.ArticlesItem
import com.example.newsapp.ModelClass.NewsModel
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

        val colorCode = "#FF5300"

        binding.sports.setOnClickListener {
            loadNews("sport")

            binding.sports.setTextColor(Color.parseColor(colorCode))
            binding.business.setTextColor(Color.BLACK)
            binding.health.setTextColor(Color.BLACK)
            binding.entertainment.setTextColor(Color.BLACK)
            binding.science.setTextColor(Color.BLACK)
//            binding.general.setTextColor(Color.BLACK)
            binding.technology.setTextColor(Color.BLACK)


            binding.lineSport.visibility = View.VISIBLE
            binding.lineBusiness.visibility = View.GONE
            binding.lineEntertainment.visibility = View.GONE
//            binding.lineGeneral.visibility = View.GONE
            binding.lineHealth.visibility = View.GONE
            binding.lineTechnology.visibility = View.GONE
            binding.lineScience.visibility = View.GONE

        }
        binding.technology.setOnClickListener {
            loadNews("technology")

            binding.technology.setTextColor(Color.parseColor(colorCode))
            binding.business.setTextColor(Color.BLACK)
            binding.health.setTextColor(Color.BLACK)
            binding.entertainment.setTextColor(Color.BLACK)
            binding.science.setTextColor(Color.BLACK)
//            binding.general.setTextColor(Color.BLACK)
            binding.sports.setTextColor(Color.BLACK)

            binding.lineTechnology.visibility = View.VISIBLE
            binding.lineBusiness.visibility = View.GONE
            binding.lineEntertainment.visibility = View.GONE
//            binding.lineGeneral.visibility = View.GONE
            binding.lineHealth.visibility = View.GONE
            binding.lineSport.visibility = View.GONE
            binding.lineScience.visibility = View.GONE

        }
        binding.business.setOnClickListener {
            loadNews("business")

            binding.business.setTextColor(Color.parseColor(colorCode))
            binding.sports.setTextColor(Color.BLACK)
            binding.health.setTextColor(Color.BLACK)
            binding.entertainment.setTextColor(Color.BLACK)
            binding.science.setTextColor(Color.BLACK)
//            binding.general.setTextColor(Color.BLACK)
            binding.technology.setTextColor(Color.BLACK)

            binding.lineBusiness.visibility = View.VISIBLE
            binding.lineSport.visibility = View.GONE
            binding.lineEntertainment.visibility = View.GONE
//            binding.lineGeneral.visibility = View.GONE
            binding.lineHealth.visibility = View.GONE
            binding.lineTechnology.visibility = View.GONE
            binding.lineScience.visibility = View.GONE
        }
        binding.health.setOnClickListener {
            loadNews("health")

            binding.health.setTextColor(Color.parseColor(colorCode))
            binding.business.setTextColor(Color.BLACK)
            binding.sports.setTextColor(Color.BLACK)
            binding.entertainment.setTextColor(Color.BLACK)
            binding.science.setTextColor(Color.BLACK)
//            binding.general.setTextColor(Color.BLACK)
            binding.technology.setTextColor(Color.BLACK)

            binding.lineHealth.visibility = View.VISIBLE
            binding.lineBusiness.visibility = View.GONE
            binding.lineEntertainment.visibility = View.GONE
//            binding.lineGeneral.visibility = View.GONE
            binding.lineSport.visibility = View.GONE
            binding.lineTechnology.visibility = View.GONE
            binding.lineScience.visibility = View.GONE
        }
//        binding.general.setOnClickListener {
//            loadNews("general")
//
//            binding.general.setTextColor(Color.parseColor(colorCode))
//            binding.business.setTextColor(Color.BLACK)
//            binding.health.setTextColor(Color.BLACK)
//            binding.entertainment.setTextColor(Color.BLACK)
//            binding.science.setTextColor(Color.BLACK)
//            binding.sports.setTextColor(Color.BLACK)
//            binding.technology.setTextColor(Color.BLACK)
//
//            binding.lineGeneral.visibility = View.VISIBLE
//            binding.lineBusiness.visibility = View.GONE
//            binding.lineEntertainment.visibility = View.GONE
//            binding.lineSport.visibility = View.GONE
//            binding.lineHealth.visibility = View.GONE
//            binding.lineTechnology.visibility = View.GONE
//            binding.lineScience.visibility = View.GONE
//        }
        binding.science.setOnClickListener {
            loadNews("science")

            binding.science.setTextColor(Color.parseColor(colorCode))
            binding.business.setTextColor(Color.BLACK)
            binding.health.setTextColor(Color.BLACK)
            binding.entertainment.setTextColor(Color.BLACK)
            binding.sports.setTextColor(Color.BLACK)
//            binding.general.setTextColor(Color.BLACK)
            binding.technology.setTextColor(Color.BLACK)

            binding.lineScience.visibility = View.VISIBLE
            binding.lineBusiness.visibility = View.GONE
            binding.lineEntertainment.visibility = View.GONE
//            binding.lineGeneral.visibility = View.GONE
            binding.lineHealth.visibility = View.GONE
            binding.lineTechnology.visibility = View.GONE
            binding.lineSport.visibility = View.GONE
        }
        binding.entertainment.setOnClickListener {
            loadNews("entertainment")

            binding.entertainment.setTextColor(Color.parseColor(colorCode))
            binding.business.setTextColor(Color.BLACK)
            binding.health.setTextColor(Color.BLACK)
            binding.sports.setTextColor(Color.BLACK)
            binding.science.setTextColor(Color.BLACK)
//            binding.general.setTextColor(Color.BLACK)
            binding.technology.setTextColor(Color.BLACK)

            binding.lineEntertainment.visibility = View.VISIBLE
            binding.lineBusiness.visibility = View.GONE
            binding.lineSport.visibility = View.GONE
//            binding.lineGeneral.visibility = View.GONE
            binding.lineHealth.visibility = View.GONE
            binding.lineTechnology.visibility = View.GONE
            binding.lineScience.visibility = View.GONE
        }
        loadNews()

        loadNews("sport")
    }


    fun loadNews() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", "general", "a5a506de67624ea9b09b1ebea7e547b4")
            .enqueue(object : Callback<NewsModel> {
                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {

                    var data = response.body()

                    Log.e(TAG, "onResponse: ========$data")

                    binding.bNewsRecycler.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                    binding.bNewsRecycler.adapter = BreakingNewsAdapter(data?.articles as ArrayList<ArticlesItem>)

//                    binding.recycler.layoutManager = LinearLayoutManager(this@MainActivity)
//                    binding.recycler.adapter =
//                        NewsAdapter(data?.articles as ArrayList<ArticlesItem>)
                    binding.lineSport.visibility = View.VISIBLE

                }

                override fun onFailure(call: Call<NewsModel>, t: Throwable) {

                    Log.e(TAG, "onFailure: ===" + t.message)
                }

            })
    }

    fun loadNews(text: String) {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getData("in", text, "a5a506de67624ea9b09b1ebea7e547b4")
            .enqueue(object : Callback<NewsModel> {
                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {

                    var data = response.body()

                    binding.recycler.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.recycler.adapter =
                        NewsAdapter(data?.articles as ArrayList<ArticlesItem>)
                }

                override fun onFailure(call: Call<NewsModel>, t: Throwable) {

                    Log.e(TAG, "onFailure: ===" + t.message)
                    binding.tvBreakingNews.visibility = View.GONE
                }

            })

    }

}