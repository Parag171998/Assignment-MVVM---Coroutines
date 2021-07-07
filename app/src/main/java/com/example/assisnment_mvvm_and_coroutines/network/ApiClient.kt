package com.example.assisnment_mvvm_and_coroutines.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor() {
    val api: ApiInterface
        get() = retrofit.create(ApiInterface::class.java)

    companion object {
        const val NEWS_BASE_URL = "https://api.flickr.com/services/"
        private var apiClient: ApiClient? = null
        private lateinit var retrofit: Retrofit

        @get:Synchronized
        val instance: ApiClient?
            get() {
                if (apiClient == null) {
                    apiClient = ApiClient()
                }
                return apiClient
            }
    }

    init {
        retrofit = Retrofit.Builder().baseUrl(NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
    }
}