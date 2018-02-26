package com.pabji.androidappmovie.presentation.ui.presenters.detail

import android.arch.lifecycle.ViewModelProviders
import android.util.Log
import com.pabji.androidappmovie.domain.callbacks.ResultCallback
import com.pabji.androidappmovie.domain.interactors.getMovieDetail.GetMovieDetailInteractor
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.SaveFavoriteMovieInteractor
import com.pabji.androidappmovie.domain.interactors.isFavoriteMovie.IsFavoriteMovieInteractor
import com.pabji.androidappmovie.domain.models.Movie
import com.pabji.androidappmovie.presentation.base.presenter.BaseActivityPresenter
import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailActivity
import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailContract
import com.pabji.androidappmovie.presentation.ui.viewModels.MovieDetailViewModel
import javax.inject.Inject

class DetailPresenter @Inject constructor(val getMovieDetailInteractor: GetMovieDetailInteractor, val saveFavoriteMovieInteractor: SaveFavoriteMovieInteractor, val isFavoriteMovieInteractor: IsFavoriteMovieInteractor): BaseActivityPresenter<DetailContract.View>(), DetailContract.Presenter {

    var mMovie: Movie? = null
    var mMovieId: Int? = null
    lateinit var viewModel: MovieDetailViewModel

    override fun initialize(movieId: Int, detailActivity: DetailActivity) {
        mMovieId = movieId
        getMovieDetail(movieId,detailActivity)

    }

    override fun saveFavorite() {
        mMovie?.let {
            saveFavoriteMovieInteractor.execute(it,object : ResultCallback<Boolean> {

                override fun success(result: Boolean) {
                        mView?.showSaved()
                }

                override fun error(error: Throwable) {
                }

            })
        }
    }

    private fun getMovieDetail(movieId: Int, detailActivity: DetailActivity) {
        getMovieDetailInteractor.execute(movieId,object : ResultCallback<Movie> {

            override fun success(result: Movie) {
                result.backdropPath?.let {
                    mView?.showImage(it)
                }
                result.title?.let {
                    mView?.showTitle(it)
                }?: run {
                    result.originalTitle?.let {
                        mView?.showTitle(it)
                    }
                }
                mMovie = result
                viewModel = ViewModelProviders.of(detailActivity).get(MovieDetailViewModel::class.java)
                viewModel.setCurrentUser(result)
            }

            override fun error(error: Throwable) {
                Log.d("ERROR",error.localizedMessage)
            }

        })
    }

    override fun checkFavorite() {
        mMovieId?.let {
            isFavoriteMovieInteractor.execute(it, object : ResultCallback<Boolean> {
                override fun success(result: Boolean) {
                    mView?.isFavorite(result)
                }

                override fun error(error: Throwable) {
                    Log.d("ERROR",error.localizedMessage)
                    mView?.isFavorite(false)
                }

            })
        }

    }





}