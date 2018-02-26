package com.pabji.androidappmovie.presentation.ui.activities.detail

import com.pabji.androidappmovie.presentation.base.presenter.BasePresenter
import com.pabji.androidappmovie.presentation.base.view.BaseView

interface DetailContract {

    interface View : BaseView {
    }

    interface Presenter : BasePresenter<View> {
        fun saveFavorite()
        fun initialize(detailActivity: DetailActivity)

    }
}