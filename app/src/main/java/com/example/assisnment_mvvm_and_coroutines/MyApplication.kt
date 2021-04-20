package com.example.assisnment_mvvm_and_coroutines

import android.app.Application
import com.example.assisnment_mvvm_and_coroutines.di.appModule
import com.example.assisnment_mvvm_and_coroutines.di.repositoryModule
import com.example.assisnment_mvvm_and_coroutines.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(appModule,
                    viewModule,
                    repositoryModule))
        }
    }
}