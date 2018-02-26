package com.pabji.androidappmovie.presentation.ui.activities.detail

import com.pabji.androidappmovie.presentation.base.presenter.BasePresenter
import com.pabji.androidappmovie.presentation.base.view.BaseView

interface DetailContract {

    interface View : BaseView {
        fun showImage(backdropPath: String?)
        fun showTitle(title: String)
        fun showSaved()
        fun isFavorite(result: Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun saveFavorite()
        fun checkFavorite()
        fun initialize(movieId: Int, detailActivity: DetailActivity)

    }
}