package com.example.mvvmlist.db

import androidx.room.*
import com.example.mvvmlist.data.model.ApiResponse

@Dao
interface PostDao {
    @Query("SELECT * FROM Posts")
    fun findAll(): List<ApiResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: List<ApiResponse>)
}


@Database(entities = [ApiResponse::class], version = 1, exportSchema = false)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}