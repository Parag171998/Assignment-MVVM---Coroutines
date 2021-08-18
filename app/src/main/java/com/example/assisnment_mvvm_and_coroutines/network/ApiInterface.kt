package com.example.assisnment_mvvm_and_coroutines.network

import com.example.assisnment_mvvm_and_coroutines.models.Album
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("api/?key=22973155-5de6fb7b28402c8db51a3dea1&image_type=photo&pretty=true")
    suspend fun getPhotos(
        @Query("q") address: String): Response<Album>?
}