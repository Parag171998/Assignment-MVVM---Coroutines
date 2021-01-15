package com.example.assisnment_mvvm_and_coroutines.repository

import com.example.assisnment_mvvm_and_coroutines.models.NewsData
import com.example.assisnment_mvvm_and_coroutines.network.NewsApiClient
import retrofit2.Response

class MyRepository {
    private val NEWS_API_KEY = "6d0df12f66ef4483bad3908f781308b1"

     suspend fun getNews(country: String?): Response<NewsData?>? {
        return NewsApiClient.instance?.api?.getHeadlines(country, NEWS_API_KEY)
    }

    companion object {
        private var myRepositoryInstance: MyRepository? = null
        val instance: MyRepository?
            get() {
                if (myRepositoryInstance == null) myRepositoryInstance = MyRepository()
                return myRepositoryInstance
            }
    }
}