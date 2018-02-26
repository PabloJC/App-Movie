package com.pabji.androidappmovie.domain.interactors.saveFavoriteMovie

import com.pabji.androidappmovie.domain.extensions.modelToRoomEntity
import com.pabji.androidappmovie.data.persistence.room.MovieDao
import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.SaveFavoriteMovieInteractor
import com.pabji.androidappmovie.domain.models.Movie


class SaveFavoriteMovieInteractorImpl(val movieDao: MovieDao) : SaveFavoriteMovieInteractor {

    override fun execute(movie: Movie, callback: ResultCallback<Boolean>) {

        movieDao.saveFavorite(movie.modelToRoomEntity())
        callback.success(true)
    }
}