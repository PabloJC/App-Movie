package com.pabji.androidappmovie.presentation.ui.main.views.fragments

import com.pabji.androidappmovie.presentation.base.presenter.BasePresenter
import com.pabji.androidappmovie.presentation.base.view.BaseFragmentView
interface PopularListContract {

    interface View : BaseFragmentView {
    }

    interface Presenter : BasePresenter<View> {
        fun initialize()
    }
}