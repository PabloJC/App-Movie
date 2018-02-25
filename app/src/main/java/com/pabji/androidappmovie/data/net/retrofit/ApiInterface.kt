package com.pabji.androidappmovie.data.net.retrofit

import com.pabji.androidappmovie.data.net.entities.SearchEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface{
    @GET("popular")
    fun getTop(@Query("api_key") apiKey: String,
               @Query("page") page: Int?,
               @Query("language") language: String?) : Observable<SearchEntity>
}