package com.pabji.androidappmovie.presentation.ui.presenters.detail

import android.arch.lifecycle.ViewModelProviders
import com.pabji.androidappmovie.presentation.base.presenter.BaseActivityPresenter
import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailActivity
import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailContract
import com.pabji.androidappmovie.presentation.ui.activities.main.MainContract
import com.pabji.androidappmovie.presentation.ui.viewModels.MovieDetailViewModel
import com.pabji.androidappmovie.presentation.utils.extensions.ViewModelFactory
import javax.inject.Inject

class DetailPresenter @Inject constructor(): BaseActivityPresenter<DetailContract.View>(), DetailContract.Presenter {

    lateinit var viewModel: MovieDetailViewModel

    override fun initialize(detailActivity: DetailActivity) {
        viewModel = ViewModelProviders.of(detailActivity).get(MovieDetailViewModel::class.java)
    }


    override fun saveFavorite() {
    }


}