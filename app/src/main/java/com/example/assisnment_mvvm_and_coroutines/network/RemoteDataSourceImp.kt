package com.example.assisnment_mvvm_and_coroutines.network

import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.models.Photo
import retrofit2.Response

class RemoteDataSourceImp (private val apiInterface: ApiInterface): RemoteDataSource{

    override suspend fun getAlbums(): Response<List<Album>>? = apiInterface.getAlbums()

    override suspend fun getPhotos(id: String):  Response<List<Photo>>? = apiInterface.getPhotos(id)
}