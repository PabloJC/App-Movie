package com.pabji.androidappmovie.presentation.ui.fragments.detail.di

import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieImageFragment
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieInfoFragment
import com.pabji.androidappmovie.presentation.ui.presenters.detail.MovieImagePresenter
import com.pabji.androidappmovie.presentation.ui.presenters.detail.MovieInfoPresenter
import dagger.Module
import dagger.Provides

@Module
abstract class MovieImageModule {

    @Module
    companion object {

        @Provides
        internal fun provideMovieImageView(movieImageFragment: MovieImageFragment): MovieImageFragment {
            return movieImageFragment
        }

        @JvmStatic
        @Provides
        fun provideMovieImagePresenter(): MovieImagePresenter {
            return MovieImagePresenter()
        }
    }

}