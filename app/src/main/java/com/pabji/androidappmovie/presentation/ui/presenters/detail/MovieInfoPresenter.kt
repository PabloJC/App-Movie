package com.pabji.androidappmovie.presentation.ui.presenters.detail

import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieInfoContract
import javax.inject.Inject


class MovieInfoPresenter @Inject constructor(): BaseFragmentPresenter<MovieInfoContract.View>(), MovieInfoContract.Presenter {

}