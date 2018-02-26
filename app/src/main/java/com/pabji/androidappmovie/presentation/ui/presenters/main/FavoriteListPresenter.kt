package com.pabji.androidappmovie.presentation.ui.presenters.main

import android.util.Log
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.interactors.getFavoriteMovies.GetFavoriteMoviesInteractor
import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.ui.fragments.main.FavoriteListContract
import javax.inject.Inject

class FavoriteListPresenter @Inject constructor(val getFavoriteMoviesInteractor : GetFavoriteMoviesInteractor): BaseFragmentPresenter<FavoriteListContract.View>(), FavoriteListContract.Presenter {


    override fun initialize() {
        getFavoriteMoviesInteractor.execute(object : ResultCallback<List<MoviePreview>> {

            override fun success(result: List<MoviePreview>) {
                mView?.showMovieList(result)
            }

            override fun error(error: Throwable) {
                Log.d("ERROR",error.localizedMessage)
            }

        })
    }

    override fun openDetail() {
    }
}