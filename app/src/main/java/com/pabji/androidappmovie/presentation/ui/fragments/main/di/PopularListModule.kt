package com.pabji.androidappmovie.presentation.ui.fragments.main.di

import com.pabji.androidappmovie.data.persistence.room.MovieDao
import com.pabji.androidappmovie.data.repositories.MovieRepository
import com.pabji.androidappmovie.domain.interactors.getMovieDetail.GetMovieDetailInteractor
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractor
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractorImpl
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.SaveFavoriteMovieInteractor
import com.pabji.androidappmovie.domain.interactors.saveFavoriteMovie.SaveFavoriteMovieInteractorImpl
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