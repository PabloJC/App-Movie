package com.pabji.androidappmovie.domain.interactors.isFavoriteMovie

import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.models.MoviePreview

interface IsFavoriteMovieInteractor {

    fun execute(movieId : Int,callback: ResultCallback<Boolean>)
}