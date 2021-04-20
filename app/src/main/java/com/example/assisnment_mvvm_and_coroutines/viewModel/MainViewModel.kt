package com.example.assisnment_mvvm_and_coroutines.viewModel

import androidx.lifecycle.ViewModel
import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.models.Photo
import com.example.assisnment_mvvm_and_coroutines.network.ApiInterface
import com.example.assisnment_mvvm_and_coroutines.repository.MyRepository
import com.example.assisnment_mvvm_and_coroutines.repository.MyRepositoryImpl
import com.example.assisnment_mvvm_and_coroutines.room.MyAppDatabase
import retrofit2.Response

class MainViewModel constructor(private val repository: MyRepositoryImpl) : ViewModel() {
    suspend fun getAlbums(): Response<List<Album>>? {
        return repository.getAlbum()
    }

    suspend fun getPhotos(id: String) : Response<List<Photo>>? = repository.getPhotos(id)
}