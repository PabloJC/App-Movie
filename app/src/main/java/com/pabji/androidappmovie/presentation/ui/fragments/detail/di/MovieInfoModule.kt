package com.pabji.androidappmovie.presentation.ui.fragments.detail.di

import android.graphics.Movie
import com.pabji.androidappmovie.data.persistence.room.MovieDao
import com.pabji.androidappmovie.data.repositories.MovieRepository
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractor
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractorImpl
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.SaveFavoriteMovieInteractor
import com.pabji.androidappmovie.domain.interactors.saveFavoriteMovie.SaveFavoriteMovieInteractorImpl
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieInfoFragment
import com.pabji.androidappmovie.presentation.ui.fragments.main.PopularListFragment
import com.pabji.androidappmovie.presentation.ui.presenters.detail.MovieInfoPresenter
import com.pabji.androidappmovie.presentation.ui.presenters.main.PopularListPresenter
import dagger.Module
import dagger.Provides

@Module
abstract class MovieInfoModule {

    @Module
    companion object {

        @Provides
        internal fun provideMovieInfoView(movieInfoFragment: MovieInfoFragment): MovieInfoFragment {
            return movieInfoFragment
        }

        @JvmStatic
        @Provides
        fun provideMovieInfoPresenter(): MovieInfoPresenter {
            return MovieInfoPresenter()
        }
    }

}