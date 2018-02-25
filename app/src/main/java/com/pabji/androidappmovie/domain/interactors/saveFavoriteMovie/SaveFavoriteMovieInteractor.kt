package com.pabji.androidappmovie.domain.interactors.getPopularMovies

import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.models.Movie
import com.pabji.androidappmovie.domain.models.MoviePreview

interface SaveFavoriteMovieInteractor {

    fun execute(movie: MoviePreview,callback: ResultCallback<Boolean>)
}