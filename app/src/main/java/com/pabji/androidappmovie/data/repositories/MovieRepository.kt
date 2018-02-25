package com.pabji.androidappmovie.data.net.repositories

import com.pabji.androidappmovie.data.net.entities.SearchEntity
import com.pabji.androidappmovie.data.net.retrofit.ApiClient
import com.pabji.androidappmovie.data.net.retrofit.ApiInterface
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(val apiClient: ApiInterface) {

    fun searchPopularMovies(page: Int?, language: String?) : Observable<SearchEntity>{
        return apiClient.getTop(ApiClient.API_KEY,page,language)
    }
}