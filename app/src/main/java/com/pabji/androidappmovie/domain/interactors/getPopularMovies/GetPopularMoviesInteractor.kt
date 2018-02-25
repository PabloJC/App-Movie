package com.pabji.androidappmovie.domain.interactors

import com.pabji.androidappmovie.data.net.models.MoviePreview

interface GetPopularMoviesInteractor {

    fun execute(page: Int?, language: String?, callback: (List<MoviePreview>) -> Unit)
}