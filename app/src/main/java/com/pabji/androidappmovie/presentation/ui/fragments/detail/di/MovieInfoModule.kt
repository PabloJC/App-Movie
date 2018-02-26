package com.pabji.androidappmovie.presentation.ui.fragments.detail.di

import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieInfoFragment
import com.pabji.androidappmovie.presentation.ui.presenters.detail.MovieInfoPresenter
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