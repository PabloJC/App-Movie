package com.pabji.androidappmovie.data.net.retrofit

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by PabloJC on 25/2/18.
 */

class ApiClient{
    private val redditApi: ApiInterface

    companion object {
        val API_BASE_URL = "https://api.themoviedb.org/3/movie"
    }

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        redditApi = retrofit.create(ApiInterface::class.java)
    }
}