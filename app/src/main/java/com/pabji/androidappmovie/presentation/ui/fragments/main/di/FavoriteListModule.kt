package com.pabji.androidappmovie.presentation.ui.main.views.fragments.di

import com.pabji.androidappmovie.presentation.ui.main.presenters.fragments.FavoriteListPresenter
import com.pabji.androidappmovie.presentation.ui.main.presenters.fragments.PopularListPresenter
import com.pabji.androidappmovie.presentation.ui.main.views.fragments.FavoriteListFragment
import com.pabji.androidappmovie.presentation.ui.main.views.fragments.PopularListFragment
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