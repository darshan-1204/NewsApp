package com.example.newsapp.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.Adapter.CategoriesAdapter
import com.example.newsapp.Adapter.NewsAdapter
import com.example.newsapp.Api.ApiClient
import com.example.newsapp.Api.ApiInterface
import com.example.newsapp.ArticlesItem
import com.example.newsapp.NewsModel
import com.example.newsapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"
    var cat = arrayOf("Sports","Technology","Business","Health","General","Science","Entertainment")
//        companion object{
//        lateinit var data : ArrayList<ArticlesItem>
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcvCat.adapter = CategoriesAdapter(cat)

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

}


