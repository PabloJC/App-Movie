package com.pabji.androidappmovie.domain.interactors.getMovieDetail

import android.util.Log
import com.pabji.androidappmovie.data.net.entities.MovieDetailEntity
import com.pabji.androidappmovie.data.repositories.MovieRepository
import com.pabji.androidappmovie.domain.base.BaseInteractor
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.extensions.detailEntityToModel
import com.pabji.androidappmovie.domain.interactors.getMovieDetail.GetMovieDetailInteractor
import com.pabji.androidappmovie.domain.models.Movie
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class GetMovieDetailInteractorImpl(val movieRepository: MovieRepository) : BaseInteractor<MovieDetailEntity>(), GetMovieDetailInteractor {

    var mEntity : MovieDetailEntity?  = null

    override fun execute(idMovie : Int,callback: ResultCallback<Movie>) {
        observable = movieRepository.getMovieDetail(idMovie)
        val observer  = object : Observer<MovieDetailEntity> {
            override fun onNext(entity: MovieDetailEntity) {
                mEntity = entity
            }

            override fun onSubscribe(d: Disposable) {
                Log.d("Subscriber","New Subscriber")
            }

            override fun onError(e: Throwable) {
                callback.error(e)
            }

            override fun onComplete() {
                mEntity?.let {
                    callback.success(it.detailEntityToModel())
                }
            }
        }
        runObserver(observer)
    }
}