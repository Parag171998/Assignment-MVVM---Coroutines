package com.example.assisnment_mvvm_and_coroutines.room

import com.example.assisnment_mvvm_and_coroutines.Album

class LocalDataSource (private val myAppDatabase: MyAppDatabase){
    fun addAllAlbums(albumList: List<Album?>?){
        myAppDatabase.mydao().addAllAlbums(albumList)
    }
}