package com.pabji.androidappmovie.domain.interactors.getMovieDetail

import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.models.Movie
import com.pabji.androidappmovie.domain.models.MoviePreview

interface GetMovieDetailInteractor {

    fun execute(idMovie : Int,callback: ResultCallback<Movie>)
}