package com.mibaldi.cah.domain.interactors.main

import android.util.Log
import com.mibaldi.cah.data.models.uimodels.Game
import com.mibaldi.cah.data.repositories.GameRepository
import com.mibaldi.cah.data.repositories.UserRepository
import com.pabji.androidappmovie.data.net.entities.SearchEntity
import com.pabji.androidappmovie.data.net.extensions.toModelList
import com.pabji.androidappmovie.data.net.models.MoviePreview
import com.pabji.androidappmovie.data.net.repositories.MovieRepository
import com.pabji.androidappmovie.domain.interactors.GetPopularMoviesInteractor
import com.pabji.androidappmovie.domain.interactors.base.BaseInteractor
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class GetPopularMoviesInteractorImpl(val movieRepository: MovieRepository) : BaseInteractor<SearchEntity>(),GetPopularMoviesInteractor {

    override fun execute(page: Int?, language: String?, callback: (List<MoviePreview>) -> Unit) {
        observable = movieRepository.searchPopularMovies(page,language)
        val observer  = object : Observer<SearchEntity> {
            override fun onNext(entity: SearchEntity) {
                entity.results?.let{
                    callback(it.toModelList())
                }
            }

            override fun onSubscribe(d: Disposable) {
                Log.d("Subscriber","New Subscriber")
            }

            override fun onError(e: Throwable) {
                Log.d("Subscriber",e.message)
            }

            override fun onComplete() {

            }
        }
        runObserver(observer)
    }
}