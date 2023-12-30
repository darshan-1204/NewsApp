package com.example.newsapp.Api

import com.example.newsapp.ModelClass.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("top-headlines")
    fun getData(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey:String
    ) : retrofit2.Call<NewsModel>


//      For searching the news
//    @GET("v2/everything")
//    fun searchData(
//        @Query("country") country: String = "in",
//        @Query("apiKey") apiKey:String
//    ) : retrofit2.Call<NewsModel>
}