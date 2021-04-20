package com.example.assisnment_mvvm_and_coroutines.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assisnment_mvvm_and_coroutines.Album

@Database(entities = [Album::class], version = 1)
abstract class MyAppDatabase : RoomDatabase() {
    abstract fun mydao(): MyDao
}