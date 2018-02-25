package com.pabji.androidappmovie.domain.interactors.saveFavoriteMovie

import com.pabji.androidappmovie.data.extensions.modelToRoomEntity
import com.pabji.androidappmovie.data.persistence.room.MovieDao
import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.SaveFavoriteMovieInteractor


class SaveFavoriteMovieInteractorImpl(val movieDao: MovieDao) : SaveFavoriteMovieInteractor {

    override fun execute(movie: MoviePreview,callback: ResultCallback<Boolean>) {

        movieDao.saveFavorite(movie.modelToRoomEntity())
        callback.success(true)
    }
}