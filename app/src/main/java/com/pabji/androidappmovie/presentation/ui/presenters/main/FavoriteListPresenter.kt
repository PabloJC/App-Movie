package com.pabji.androidappmovie.presentation.ui.main.presenters.fragments

import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.ui.main.views.fragments.FavoriteListContract
import javax.inject.Inject

class FavoriteListPresenter @Inject constructor(): BaseFragmentPresenter<FavoriteListContract.View>(), FavoriteListContract.Presenter {

    override fun initialize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}