package com.pabji.androidappmovie.domain.callbacks

interface ResultCallback<in T> {

    fun success(result: T)
    fun error(error: Throwable)
}