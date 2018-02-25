package com.pabji.androidappmovie.data.net.retrofit

import com.pabji.androidappmovie.data.net.entities.SearchEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiInterface{
    @GET("popular")
    fun getTop(@QueryMap queries : Map<String, String>) : Call<SearchEntity>
}