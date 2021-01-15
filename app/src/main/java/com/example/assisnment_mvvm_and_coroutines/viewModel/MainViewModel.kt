package com.example.assisnment_mvvm_and_coroutines.viewModel

import androidx.lifecycle.ViewModel
import com.example.assisnment_mvvm_and_coroutines.models.NewsData
import com.example.assisnment_mvvm_and_coroutines.repository.MyRepository
import retrofit2.Response

class MainViewModel : ViewModel() {
    private var myRepository: MyRepository? = null
    fun init() {
        myRepository = MyRepository.instance
    }

    suspend fun getHeadlines(country: String?): Response<NewsData?>? {
        if (myRepository == null) {
            myRepository = MyRepository.instance
        }
        return myRepository!!.getNews(country)
    }
}