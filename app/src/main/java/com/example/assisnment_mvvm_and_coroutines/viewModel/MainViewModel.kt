package com.example.assisnment_mvvm_and_coroutines.viewModel

import androidx.lifecycle.ViewModel
import com.example.assisnment_mvvm_and_coroutines.models.Album
import com.example.assisnment_mvvm_and_coroutines.repository.MyRepositoryImpl
import retrofit2.Response

class MainViewModel constructor(private val repository: MyRepositoryImpl) : ViewModel() {
    suspend fun getPhotos(value: String): Response<Album>? = repository.getPhotos(value)
}