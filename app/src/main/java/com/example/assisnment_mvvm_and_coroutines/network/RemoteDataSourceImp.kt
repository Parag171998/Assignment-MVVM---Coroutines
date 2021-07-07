package com.example.assisnment_mvvm_and_coroutines.network

import com.example.assisnment_mvvm_and_coroutines.models.Album
import retrofit2.Response

class RemoteDataSourceImp(private val apiInterface: ApiInterface) : RemoteDataSource {
    override suspend fun getPhotos(): Response<Album>? =
        apiInterface.getPhotos()
}