package com.pabji.androidappmovie.data.persistence.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.pabji.androidappmovie.data.persistence.entities.MovieRoomEntity
import io.reactivex.Flowable

@Dao
interface MovieDao {

    @Query("select * from movie")
    fun getFavoriteMovies(): Flowable<List<MovieRoomEntity>>

    @Insert(onConflict = REPLACE)
    fun saveFavorite(movie: MovieRoomEntity)
}