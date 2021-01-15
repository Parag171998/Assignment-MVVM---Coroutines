package com.example.assisnment_mvvm_and_coroutines.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiClient private constructor() {
    val api: ApiInterface
        get() = retrofit.create(ApiInterface::class.java)

    companion object {
        private const val NEWS_BASE_URL = "https://newsapi.org/v2/"
        private var newsApiClient: NewsApiClient? = null
        private lateinit var retrofit: Retrofit

        @get:Synchronized
        val instance: NewsApiClient?
            get() {
                if (newsApiClient == null) {
                    newsApiClient = NewsApiClient()
                }
                return newsApiClient
            }
    }

    init {
        retrofit = Retrofit.Builder().baseUrl(NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
    }
}