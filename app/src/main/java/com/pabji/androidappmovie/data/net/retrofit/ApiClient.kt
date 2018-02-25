package com.pabji.androidappmovie.data.net.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor() {

    companion object {
        private val API_BASE_URL = "https://api.themoviedb.org/3/movie/"
        val API_KEY = "b66ffea8276ce576d60df52600822c88"
        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }

}