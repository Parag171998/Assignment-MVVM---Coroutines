package com.example.assisnment_mvvm_and_coroutines.repository

import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.models.Photo
import com.example.assisnment_mvvm_and_coroutines.network.RemoteDataSourceImp
import com.example.assisnment_mvvm_and_coroutines.room.LocalDataSourceImp
import retrofit2.Response

class MyRepositoryImpl(private val remoteDataSourceImp: RemoteDataSourceImp, private val localDataSourceImp: LocalDataSourceImp) : MyRepository {

     override suspend fun getAlbum(): Response<List<Album>>? {
         val albumList = remoteDataSourceImp.getAlbums()
         localDataSourceImp.addAllAlbums(albumList?.body())
        return albumList
    }

    override suspend fun getPhotos(id: String): Response<List<Photo>>? {
        return remoteDataSourceImp.getPhotos(id)
    }

//    companion object {
//        private var myRepositoryImplInstance: MyRepositoryImpl? = null
//        val instance: MyRepositoryImpl?
//            get() {
//                if (myRepositoryImplInstance == null) myRepositoryImplInstance = MyRepositoryImpl(ApiClient.instance?.api)
//                return myRepositoryImplInstance
//            }
//    }
}