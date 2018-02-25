package com.pabji.androidappmovie.data.persistence

import android.arch.persistence.room.Room
import android.content.Context
import com.pabji.androidappmovie.data.persistence.room.MovieRoomDatabase
import dagger.Module
import dagger.Provides

@Module
class PersistenceModule {

    @Provides
    fun providesAppDatabase(context: Context): MovieRoomDatabase =
            Room.databaseBuilder(context, MovieRoomDatabase::class.java, "movie-db").allowMainThreadQueries().build()

    @Provides
    fun providesToDoDao(database: MovieRoomDatabase) = database.taskDao()
}



