package com.example.assisnment_mvvm_and_coroutines

import com.example.assisnment_mvvm_and_coroutines.network.ApiInterface
import com.example.assisnment_mvvm_and_coroutines.network.RemoteDataSourceImp
import kotlinx.coroutines.*
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainRemoteTestCase {

    @Mock
    lateinit var apiInterface: ApiInterface
    lateinit var remoteDataSourceImp: RemoteDataSourceImp

    @Before
    fun setUp(){
        remoteDataSourceImp = RemoteDataSourceImp(apiInterface)
    }

    @Test
    fun `SHOULD call apiInterface#getPhotos WHEN apiInterface#getPhotos is called`() {
        runBlocking {
            val result = remoteDataSourceImp.getPhotos()
            assertThat(result?.isSuccessful, equalTo(true));
        }
    }
}