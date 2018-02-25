package com.pabji.androidappmovie.presentation.ui.presenters.main

import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.ui.fragments.main.FavoriteListContract
import javax.inject.Inject

class FavoriteListPresenter @Inject constructor(): BaseFragmentPresenter<FavoriteListContract.View>(), FavoriteListContract.Presenter {

    override fun initialize() {
    }
}