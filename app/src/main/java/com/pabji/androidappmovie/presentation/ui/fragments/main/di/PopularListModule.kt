package com.pabji.androidappmovie.presentation.ui.fragments.main.di

import com.pabji.androidappmovie.data.repositories.MovieRepository
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractor
import com.pabji.androidappmovie.presentation.ui.fragments.main.PopularListFragment
import com.pabji.androidappmovie.presentation.ui.presenters.main.PopularListPresenter
import dagger.Module
import dagger.Provides


@Module
abstract class PopularListModule {

    @Module
    companion object {

        @Provides
        internal fun providePopularListView(popularListFragment: PopularListFragment): PopularListFragment {
            return popularListFragment
        }

        @JvmStatic
        @Provides
        internal fun provideGetPopularMoviesInteractor(movieRepository: MovieRepository): GetPopularMoviesInteractor {
            return GetPopularMoviesInteractorImpl(movieRepository)
        }

        @JvmStatic
        @Provides
        fun providePopularListPresenter(getPopularMoviesInteractor: GetPopularMoviesInteractor): PopularListPresenter {
            return PopularListPresenter(getPopularMoviesInteractor)
        }
    }

}