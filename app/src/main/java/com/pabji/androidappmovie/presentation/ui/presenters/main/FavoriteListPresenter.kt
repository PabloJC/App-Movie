package com.pabji.androidappmovie.presentation.ui.presenters.main

import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetFavoriteMoviesInteractor
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractor
import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.ui.fragments.main.FavoriteListContract
import javax.inject.Inject

class FavoriteListPresenter @Inject constructor(val getFavoriteMoviesInteractor : GetFavoriteMoviesInteractor): BaseFragmentPresenter<FavoriteListContract.View>(), FavoriteListContract.Presenter {
    override fun openDetail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initialize() {
    }
}