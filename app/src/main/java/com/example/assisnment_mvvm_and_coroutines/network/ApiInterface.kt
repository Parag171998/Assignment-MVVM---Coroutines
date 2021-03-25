package com.example.assisnment_mvvm_and_coroutines.network

import android.provider.MediaStore
import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.models.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("albums")
    suspend fun getAlbums(
    ): Response<List<Album>>?

    @GET("photos")
    suspend fun getPhotos(
        @Query("albumId") albumid: String
    ): Response<List<Photo>>?
}