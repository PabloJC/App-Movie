package com.pabji.androidappmovie.presentation.ui.main.views.fragments.di

import com.pabji.androidappmovie.presentation.ui.main.presenters.fragments.PopularListPresenter
import com.pabji.androidappmovie.presentation.ui.main.views.fragments.PopularListFragment
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
        fun providePopularListPresenter(): PopularListPresenter {
            return PopularListPresenter()
        }
    }

}