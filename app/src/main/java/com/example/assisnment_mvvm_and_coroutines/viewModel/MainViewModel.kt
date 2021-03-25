package com.example.assisnment_mvvm_and_coroutines.viewModel

import androidx.lifecycle.ViewModel
import com.example.assisnment_mvvm_and_coroutines.Album
import com.example.assisnment_mvvm_and_coroutines.repository.MyRepository
import retrofit2.Response

class MainViewModel : ViewModel() {
    private var myRepository: MyRepository? = null
    fun init() {
        myRepository = MyRepository.instance
    }

    suspend fun getAlbums(): Response<List<Album>>? {
        if (myRepository == null) {
            myRepository = MyRepository.instance
        }
        return myRepository!!.getAlbum()
    }
}