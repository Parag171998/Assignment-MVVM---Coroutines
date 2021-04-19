package com.example.assisnment_mvvm_and_coroutines.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assisnment_mvvm_and_coroutines.Album

@Database(entities = [Album::class], version = 1)
abstract class MyAppDatabase : RoomDatabase() {
    abstract fun mydao(): MyDao

//    companion object {
//        private var INSTANCE: MyAppDatabase? = null
//
//        fun getDatabase(context: Context): MyAppDatabase? {
//            if (INSTANCE == null) {
//                synchronized(MyAppDatabase::class.java) {
//                    if (INSTANCE == null) {
//                        INSTANCE = Room.databaseBuilder(context.applicationContext,
//                                MyAppDatabase::class.java, "albums")
//                                .fallbackToDestructiveMigration()
//                                .build()
//                    }
//                }
//            }
//            return INSTANCE
//        }
//    }
}