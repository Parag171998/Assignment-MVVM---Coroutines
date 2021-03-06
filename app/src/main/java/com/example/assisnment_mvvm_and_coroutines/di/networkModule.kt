package com.example.assisnment_mvvm_and_coroutines.di

import android.content.Context
import androidx.room.Room
import com.example.assisnment_mvvm_and_coroutines.network.ApiClient
import com.example.assisnment_mvvm_and_coroutines.network.ApiInterface
import com.example.assisnment_mvvm_and_coroutines.network.RemoteDataSourceImp
import com.example.assisnment_mvvm_and_coroutines.repository.MyRepositoryImpl
import com.example.assisnment_mvvm_and_coroutines.room.LocalDataSourceImp
import com.example.assisnment_mvvm_and_coroutines.room.MyAppDatabase
import com.example.assisnment_mvvm_and_coroutines.viewModel.MainViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module{
    single { provideRetrofit() }
    single { provideApiInterface(get() as Retrofit) }
    single { provideDatabase(androidApplication()) }
    single { RemoteDataSourceImp(get() as ApiInterface) }
    single { LocalDataSourceImp(get() as MyAppDatabase) }
}

val viewModule = module {
    viewModel { MainViewModel(get() as MyRepositoryImpl) }
}

val repositoryModule = module {
    single { MyRepositoryImpl(get() as RemoteDataSourceImp, get() as LocalDataSourceImp) }
}

private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder().baseUrl(ApiClient.NEWS_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
}

private fun provideApiInterface(retrofit: Retrofit): ApiInterface{
    return retrofit.create(ApiInterface::class.java)
}

private fun provideDatabase(context: Context): MyAppDatabase{
    return Room.databaseBuilder(context.applicationContext,
        MyAppDatabase::class.java, "albums")
        .fallbackToDestructiveMigration()
        .build()
}