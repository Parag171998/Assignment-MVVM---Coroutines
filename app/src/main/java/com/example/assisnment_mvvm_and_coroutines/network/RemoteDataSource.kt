package com.example.assisnment_mvvm_and_coroutines.network

import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.models.Photo
import retrofit2.Response

class RemoteDataSource (private val apiInterface: ApiInterface){

    suspend fun getAlbums(): Response<List<Album>>? = apiInterface.getAlbums()

    suspend fun getPhotos(id: String):  Response<List<Photo>>? = apiInterface.getPhotos(id)
}