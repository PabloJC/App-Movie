package com.pabji.androidappmovie.presentation.ui.presenters.detail

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import android.arch.lifecycle.Observer
import com.pabji.androidappmovie.domain.models.Movie
import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieImageContract
import com.pabji.androidappmovie.presentation.ui.viewModels.MovieDetailViewModel
import java.text.NumberFormat
import java.util.*
import javax.inject.Inject

class MovieImagePresenter @Inject constructor(): BaseFragmentPresenter<MovieImageContract.View>(), MovieImageContract.Presenter {

    override fun initialize(activity: FragmentActivity) {
        val viewModel = ViewModelProviders.of(activity).get(MovieDetailViewModel::class.java)
        viewModel.getCurrentMovie().observe(activity, Observer<Movie> {
            movie -> movie?.let {
                it.posterPath?.let {
                    mView?.showImage(it)
                }
            }
        })
    }

}