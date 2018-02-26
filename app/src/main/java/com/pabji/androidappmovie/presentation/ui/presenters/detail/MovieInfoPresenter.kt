package com.pabji.androidappmovie.presentation.ui.presenters.detail

import android.arch.lifecycle.Observer
import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieInfoContract
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProviders
import android.icu.util.Currency
import android.icu.util.CurrencyAmount
import android.support.v4.app.FragmentActivity
import com.pabji.androidappmovie.domain.models.Movie
import com.pabji.androidappmovie.presentation.ui.viewModels.MovieDetailViewModel
import java.text.NumberFormat
import java.util.*


class MovieInfoPresenter @Inject constructor(): BaseFragmentPresenter<MovieInfoContract.View>(), MovieInfoContract.Presenter {

    override fun initialize(activity: FragmentActivity) {
        val viewModel = ViewModelProviders.of(activity).get(MovieDetailViewModel::class.java)
        viewModel.getCurrentMovie().observe(activity, Observer<Movie> {
            movie -> movie?.let {
            mView?.showData(movie)

            mView?.showGenres(it.genres?.map { it.name }?.joinToString(", "))

            movie.budget?.let {
                val format = NumberFormat.getCurrencyInstance(Locale.US)
                val currency = format.format(it)
                mView?.showBudget(currency)

            }

            movie.releaseDate?.let {
                mView?.showDate(it)
            }

        }

        })
    }

}