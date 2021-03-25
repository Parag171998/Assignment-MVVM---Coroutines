package com.example.assisnment_mvvm_and_coroutines.repository

import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.network.ApiClient
import retrofit2.Response

class MyRepository {

     suspend fun getAlbum(): Response<List<Album>>? {
        return ApiClient.instance?.api?.getAlbums()
    }

    companion object {
        private var myRepositoryInstance: MyRepository? = null
        val instance: MyRepository?
            get() {
                if (myRepositoryInstance == null) myRepositoryInstance = MyRepository()
                return myRepositoryInstance
            }
    }
}