package com.example.assisnment_mvvm_and_coroutines.room

import com.example.assisnment_mvvm_and_coroutines.Album

interface LocalDataSource{
    suspend fun addAllAlbums(albumList: List<Album?>?)
}