package com.pabji.androidappmovie.data.persistence.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.pabji.androidappmovie.data.persistence.entities.MovieRoomEntity
import io.reactivex.Flowable

@Dao
interface MovieDao {

    @Query("select * from movie")
    fun getFavoriteMovies(): Flowable<List<MovieRoomEntity>>
}