package com.pabji.androidappmovie.data.net.retrofit

import com.pabji.androidappmovie.data.net.entities.MovieDetailEntity
import com.pabji.androidappmovie.data.net.entities.SearchEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface{
    @GET("popular")
    fun getPopularMovies(@Query("api_key") apiKey: String,
                         @Query("page") page: Int?,
                         @Query("language") language: String?) : Observable<SearchEntity>

    @GET("{movie_id}")
    fun getMovieDetail(@Path("movie_id") id: Int,
                       @Query("api_key") apiKey: String,
                       @Query("language") language: String?) : Observable<MovieDetailEntity>
}