package com.example.assisnment_mvvm_and_coroutines.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.assisnment_mvvm_and_coroutines.Album

@Dao
interface MyDao {
    @Insert
    fun addAlbum(article: Album?)

    @Insert
    fun addAllAlbums(albumList: List<Album?>?)

    @get:Query("select * from Album")
    val favAlbum: List<Album?>?

    @Query("DELETE FROM Album")
    fun deleteAll()

    @Query("select * from Album where id = :id")
    fun checkIfPresent(id: String?): Album?

    @Delete
    fun deleteAlbum(article: Album?)
}