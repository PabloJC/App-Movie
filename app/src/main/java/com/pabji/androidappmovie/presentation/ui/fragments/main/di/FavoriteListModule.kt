package com.pabji.androidappmovie.presentation.ui.fragments.main.di

import com.pabji.androidappmovie.data.persistence.room.MovieDao
import com.pabji.androidappmovie.data.repositories.MovieRepository
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetFavoriteMoviesInteractor
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetFavoriteMoviesInteractorImpl
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractor
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.GetPopularMoviesInteractorImpl
import com.pabji.androidappmovie.presentation.ui.fragments.main.FavoriteListFragment
import com.pabji.androidappmovie.presentation.ui.presenters.main.FavoriteListPresenter
import dagger.Module
import dagger.Provides

@Module
abstract class FavoriteListModule {

    @Module
    companion object {

        @Provides
        internal fun provideFavoriteListView(favoriteListFragment: FavoriteListFragment): FavoriteListFragment {
            return favoriteListFragment
        }

        @JvmStatic
        @Provides
        internal fun provideGetFavoriteMoviesInteractor(dao: MovieDao): GetFavoriteMoviesInteractor {
            return GetFavoriteMoviesInteractorImpl(dao)
        }

        @JvmStatic
        @Provides
        fun provideFavoriteListPresenter(getFavoriteMoviesInteractor: GetFavoriteMoviesInteractor): FavoriteListPresenter {
            return FavoriteListPresenter(getFavoriteMoviesInteractor)
        }
    }

}