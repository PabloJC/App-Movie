package com.pabji.androidappmovie.domain.interactors.getPopularMovies

import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.models.MoviePreview

interface GetPopularMoviesInteractor {

    fun execute(page: Int?, callback: ResultCallback<List<MoviePreview>>)
}