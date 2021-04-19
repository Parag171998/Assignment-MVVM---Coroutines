package com.example.assisnment_mvvm_and_coroutines

import com.example.assisnment_mvvm_and_coroutines.repository.MyRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ResponseTestCase {

    private lateinit var myRepositoryImpl: MyRepositoryImpl

    @Before
    fun setup(){
        myRepositoryImpl = MyRepositoryImpl()
    }

    @Test
    fun response_isNotNull() {
        runBlocking {
            val result = myRepositoryImpl.getNews("us")
            assert(result?.isSuccessful == true)
        }
    }
}