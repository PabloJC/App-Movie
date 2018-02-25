package com.pabji.androidappmovie.presentation.ui.main.view;

import com.pabji.androidappmovie.presentation.ui.base.presenter.BasePresenter
import com.pabji.androidappmovie.presentation.ui.base.view.BaseView

interface MainContract {

    interface View : BaseView {
    }

    interface Presenter : BasePresenter<View> {

    }
}
