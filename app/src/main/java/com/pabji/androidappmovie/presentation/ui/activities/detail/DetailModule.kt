package com.pabji.androidappmovie.presentation.ui.activities.detail

import com.pabji.androidappmovie.data.persistence.room.MovieDao
import com.pabji.androidappmovie.data.repositories.MovieRepository
import com.pabji.androidappmovie.domain.interactors.getFavoriteMovies.IsFavoriteMovieInteractorImpl
import com.pabji.androidappmovie.domain.interactors.getMovieDetail.GetMovieDetailInteractor
import com.pabji.androidappmovie.domain.interactors.getMovieDetail.GetMovieDetailInteractorImpl
import com.pabji.androidappmovie.domain.interactors.getPopularMovies.SaveFavoriteMovieInteractor
import com.pabji.androidappmovie.domain.interactors.isFavoriteMovie.IsFavoriteMovieInteractor
import com.pabji.androidappmovie.domain.interactors.saveFavoriteMovie.SaveFavoriteMovieInteractorImpl
import com.pabji.androidappmovie.presentation.ui.presenters.detail.DetailPresenter
import dagger.Module
import dagger.Provides

@Module
abstract class DetailModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        internal fun provideGetMovieDetailInteractor(movieRepository: MovieRepository): GetMovieDetailInteractor {
            return GetMovieDetailInteractorImpl(movieRepository)
        }

        @JvmStatic
        @Provides
        internal fun provideSaveFavoriteMovieInteractor(dao: MovieDao): SaveFavoriteMovieInteractor {
            return SaveFavoriteMovieInteractorImpl(dao)
        }

        @JvmStatic
        @Provides
        internal fun provideIsFavoriteMovieInteractor(dao: MovieDao): IsFavoriteMovieInteractor {
            return IsFavoriteMovieInteractorImpl(dao)
        }

        @JvmStatic
        @Provides
        fun provideMainPresenter(getMovieDetailInteractor: GetMovieDetailInteractor, saveFavoriteMovieInteractor: SaveFavoriteMovieInteractor, isFavoriteMovieInteractor: IsFavoriteMovieInteractor): DetailPresenter {
            return DetailPresenter(getMovieDetailInteractor,saveFavoriteMovieInteractor, isFavoriteMovieInteractor)
        }


    }

}