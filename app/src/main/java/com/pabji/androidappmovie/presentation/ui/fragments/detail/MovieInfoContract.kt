package com.pabji.androidappmovie.presentation.ui.fragments.detail

import android.support.v4.app.FragmentActivity
import com.pabji.androidappmovie.domain.models.Movie
import com.pabji.androidappmovie.presentation.base.presenter.BasePresenter
import com.pabji.androidappmovie.presentation.base.view.BaseFragmentView

interface MovieInfoContract {

    interface View : BaseFragmentView {
        fun showTitle(title: String?)
        fun showData(movie: Movie)
        fun showGenres(joinToString: String?)
        fun showBudget(budget: String)
        fun showDate(date: String)
    }

    interface Presenter : BasePresenter<View> {
        fun initialize(activity: FragmentActivity)
    }
}