package com.pabji.androidappmovie.domain.interactors.getPopularMovies

import android.util.Log
import com.pabji.androidappmovie.data.net.entities.SearchEntity
import com.pabji.androidappmovie.data.extensions.toModelList
import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.data.repositories.MovieRepository
import com.pabji.androidappmovie.domain.base.BaseInteractor
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class GetPopularMoviesInteractorImpl(val movieRepository: MovieRepository) : BaseInteractor<SearchEntity>(), GetPopularMoviesInteractor {

    override fun execute(page: Int?, callback: ResultCallback<List<MoviePreview>>) {
        observable = movieRepository.searchPopularMovies(page)
        val observer  = object : Observer<SearchEntity> {
            override fun onNext(entity: SearchEntity) {
                entity.results?.let{
                    callback.success(it.toModelList())
                }
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