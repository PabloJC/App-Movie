package com.pabji.androidappmovie.presentation.ui.fragments.main

import com.pabji.androidappmovie.presentation.base.presenter.BasePresenter
import com.pabji.androidappmovie.presentation.base.view.BaseFragmentView

interface FavoriteListContract {

    interface View : BaseFragmentView {
    }

    interface Presenter : BasePresenter<View> {
        fun initialize()
    }
}