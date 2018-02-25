package com.pabji.androidappmovie.presentation.ui.main.views;

import com.pabji.androidappmovie.presentation.base.presenter.BasePresenter
import com.pabji.androidappmovie.presentation.base.view.BaseView

interface MainContract {

    interface View : BaseView {
    }

    interface Presenter : BasePresenter<View> {

    }
}
