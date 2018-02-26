package com.pabji.androidappmovie.presentation.ui.presenters.main

import android.util.Log
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractor
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.SaveFavoriteMovieInteractor
import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.ui.fragments.main.PopularListContract
import javax.inject.Inject

class PopularListPresenter @Inject constructor(val getPopularMoviesInteractor: GetPopularMoviesInteractor): BaseFragmentPresenter<PopularListContract.View>(), PopularListContract.Presenter {

    var page : Int = 0
    override fun initialize() {
        mView?.resetList()
        page = 1
        getPage()
    }

    fun getPage(){
        getPopularMoviesInteractor.execute(page,object : ResultCallback<List<MoviePreview>> {

            override fun success(result: List<MoviePreview>) {
                mView?.showMovieList(result)
                page++
            }

            override fun error(error: Throwable) {
                Log.d("ERROR",error.localizedMessage)
            }

        })
    }

    override fun getNextPage() {
        mView?.showLoading()
        getPage()
    }

}
