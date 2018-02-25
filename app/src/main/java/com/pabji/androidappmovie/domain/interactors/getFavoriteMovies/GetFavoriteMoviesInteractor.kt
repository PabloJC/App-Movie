package com.pabji.androidappmovie.domain.interactors.getPopularMovies

import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.models.MoviePreview

interface GetFavoriteMoviesInteractor {

    fun execute(callback: ResultCallback<List<MoviePreview>>)
}