package com.pabji.androidappmovie.data.persistence.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.pabji.androidappmovie.data.persistence.entities.MovieRoomEntity

@Database(entities = arrayOf(MovieRoomEntity::class), version = 1, exportSchema = false)
abstract class MovieRoomDatabase : RoomDatabase() {

    abstract fun taskDao(): MovieDao
}