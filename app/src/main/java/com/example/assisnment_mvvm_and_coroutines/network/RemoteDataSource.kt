package com.example.assisnment_mvvm_and_coroutines.network

import com.example.assisnment_mvvm_and_coroutines.models.Album
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getPhotos(value: String): Response<Album>?
}