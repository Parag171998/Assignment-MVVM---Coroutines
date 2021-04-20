package com.example.assisnment_mvvm_and_coroutines.room

import com.example.assisnment_mvvm_and_coroutines.Album

class LocalDataSourceImp (private val myAppDatabase: MyAppDatabase) : LocalDataSource{
    override suspend fun addAllAlbums(albumList: List<Album?>?){
        myAppDatabase.mydao().addAllAlbums(albumList)
    }
}