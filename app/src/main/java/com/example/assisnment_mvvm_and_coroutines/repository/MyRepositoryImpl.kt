package com.example.assisnment_mvvm_and_coroutines.repository

import com.example.assisnment_mvvm_and_coroutines.models.Album
import com.example.assisnment_mvvm_and_coroutines.network.RemoteDataSourceImp
import retrofit2.Response

class MyRepositoryImpl(private val remoteDataSourceImp: RemoteDataSourceImp) : MyRepository {

    override suspend fun getPhotos(): Response<Album>? {
        return remoteDataSourceImp.getPhotos()
    }
}