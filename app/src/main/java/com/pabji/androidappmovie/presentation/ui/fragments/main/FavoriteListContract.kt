package com.pabji.androidappmovie.presentation.ui.fragments.main

import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.presentation.base.presenter.BasePresenter
import com.pabji.androidappmovie.presentation.base.view.BaseFragmentView

interface FavoriteListContract {

    interface View : BaseFragmentView {
        fun showMovieList(list: List<MoviePreview>)
    }

    interface Presenter : BasePresenter<View> {
        fun initialize()
        fun openDetail()
    }
}