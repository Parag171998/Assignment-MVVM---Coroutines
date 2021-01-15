package com.example.assisnment_mvvm_and_coroutines.network

import com.example.assisnment_mvvm_and_coroutines.models.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?
    ): Response<NewsData?>?
}