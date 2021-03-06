package com.pabji.androidappmovie.data.repositories

import com.pabji.androidappmovie.data.net.entities.MovieDetailEntity
import com.pabji.androidappmovie.data.net.entities.SearchEntity
import com.pabji.androidappmovie.data.net.retrofit.ApiClient
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor() {

    private val apiClient by lazy {
        ApiClient.create()
    }

    fun searchPopularMovies(page: Int?, language: String = "es") : Observable<SearchEntity>{
        return apiClient.getPopularMovies(ApiClient.API_KEY,page,language)
    }

    fun getMovieDetail(idMovie: Int,language: String = "es"): Observable<MovieDetailEntity>? {
        return apiClient.getMovieDetail(idMovie,ApiClient.API_KEY,language)
    }
}