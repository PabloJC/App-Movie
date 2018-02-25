package com.pabji.androidappmovie.presentation.ui.fragments.main.di

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
        fun provideFavoriteListPresenter(): FavoriteListPresenter {
            return FavoriteListPresenter()
        }
    }

}