package com.pabji.androidappmovie.presentation.ui.main.views.fragments.di

import com.pabji.androidappmovie.presentation.ui.main.views.fragments.FavoriteListFragment
import com.pabji.androidappmovie.presentation.ui.main.views.fragments.PopularListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainFragmentsProvider {

    @ContributesAndroidInjector(modules = arrayOf(PopularListModule::class))
    internal abstract fun providePopularListFragmentFactory(): PopularListFragment

    @ContributesAndroidInjector(modules = arrayOf(FavoriteListModule::class))
    internal abstract fun provideFavoriteListFragmentFactory(): FavoriteListFragment
}
