package com.pabji.androidappmovie.domain.interactors.getFavoriteMovies

import android.util.Log
import com.pabji.androidappmovie.data.persistence.entities.MovieRoomEntity
import com.pabji.androidappmovie.data.persistence.room.MovieDao
import com.pabji.androidappmovie.domain.base.BaseInteractor
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.interactors.isFavoriteMovie.IsFavoriteMovieInteractor
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class IsFavoriteMovieInteractorImpl(val movieDao: MovieDao) : BaseInteractor<MovieRoomEntity>(), IsFavoriteMovieInteractor {

    override fun execute(movieId : Int,callback: ResultCallback<Boolean>) {

        observable = movieDao.getFavorite(movieId).toObservable()
        val observer  = object : Observer<MovieRoomEntity> {
            override fun onNext(result: MovieRoomEntity) {
                callback.success(true)
            }

            override fun onSubscribe(d: Disposable) {
                Log.d("Subscriber","New Subscriber")
            }

            override fun onError(e: Throwable) {
                callback.error(e)
            }

            override fun onComplete() {}
        }
        runObserver(observer)
    }
}