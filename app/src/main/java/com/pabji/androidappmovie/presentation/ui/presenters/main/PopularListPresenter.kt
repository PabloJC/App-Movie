package com.pabji.androidappmovie.presentation.ui.presenters.main

import android.util.Log
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractor
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.SaveFavoriteMovieInteractor
import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.ui.fragments.main.PopularListContract
import javax.inject.Inject

class PopularListPresenter @Inject constructor(val getPopularMoviesInteractor : GetPopularMoviesInteractor,val saveFavoriteMovieInteractor: SaveFavoriteMovieInteractor): BaseFragmentPresenter<PopularListContract.View>(), PopularListContract.Presenter {

    override fun initialize() {
        mView?.resetList()
        getPage()
    }

    fun getPage(page : Int = 1){
        getPopularMoviesInteractor.execute(page,object : ResultCallback<List<MoviePreview>> {

            override fun success(result: List<MoviePreview>) {
                mView?.showMovieList(result)
            }

            override fun error(error: Throwable) {
                Log.d("ERROR",error.localizedMessage)
            }

        })
    }

    fun openDetail(moviePreview: MoviePreview) {
        saveFavoriteMovieInteractor.execute(moviePreview,object : ResultCallback<Boolean> {

            override fun success(result: Boolean) {
                if(result){
                    mView?.showSaved()
                }
            }

            override fun error(error: Throwable) {
                Log.d("ERROR",error.localizedMessage)
            }

        })
    }
}
