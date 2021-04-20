package com.example.assisnment_mvvm_and_coroutines.network

import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.models.Photo
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getAlbums(): Response<List<Album>>?

    suspend fun getPhotos(id: String):  Response<List<Photo>>?
}