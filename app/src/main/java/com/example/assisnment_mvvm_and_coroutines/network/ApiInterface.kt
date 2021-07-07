package com.example.assisnment_mvvm_and_coroutines.network

import com.example.assisnment_mvvm_and_coroutines.models.Album
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("rest?method=flickr.photos.search&api_key=641c87bd78e54920b01e9a5d8bb726d7&format=json&nojsoncallback=1&extras=url_q&text=polo&page=2")
    suspend fun getPhotos(
    ): Response<Album>?
}