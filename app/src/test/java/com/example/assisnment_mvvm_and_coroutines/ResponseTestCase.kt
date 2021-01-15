package com.example.assisnment_mvvm_and_coroutines

import com.example.assisnment_mvvm_and_coroutines.repository.MyRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ResponseTestCase {

    private lateinit var myRepository: MyRepository

    @Before
    fun setup(){
        myRepository = MyRepository()
    }

    @Test
    fun response_isNotNull() {
        runBlocking {
            val result = myRepository.getNews("us")
            assert(result?.isSuccessful == true)
        }
    }
}