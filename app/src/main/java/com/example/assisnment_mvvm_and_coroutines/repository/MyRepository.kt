package com.example.assisnment_mvvm_and_coroutines.repository

import com.example.assisnment_mvvm_and_coroutines.models.Album
import retrofit2.Response

interface MyRepository {
    suspend fun getPhotos(): Response<Album>?
}