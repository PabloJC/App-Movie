package com.pabji.androidappmovie.domain.interactors.getPopularMovies

import android.util.Log
import com.pabji.androidappmovie.data.extensions.previewEntityListToModelList
import com.pabji.androidappmovie.data.extensions.roomEntityListToModelList
import com.pabji.androidappmovie.data.persistence.entities.MovieRoomEntity
import com.pabji.androidappmovie.data.persistence.room.MovieDao
import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.domain.base.BaseInteractor
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class GetFavoriteMoviesInteractorImpl(val movieDao: MovieDao) : BaseInteractor<List<MovieRoomEntity>>(), GetFavoriteMoviesInteractor {

    override fun execute(callback: ResultCallback<List<MoviePreview>>) {

        observable = movieDao.getFavoriteMovies().toObservable()
        val observer  = object : Observer<List<MovieRoomEntity>> {
            override fun onNext(result: List<MovieRoomEntity>) {
                callback.success(result.roomEntityListToModelList())
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