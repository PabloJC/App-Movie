package com.pabji.androidappmovie.presentation.ui.fragments.detail.di

import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieImageFragment
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieInfoFragment
import com.pabji.androidappmovie.presentation.ui.fragments.main.FavoriteListFragment
import com.pabji.androidappmovie.presentation.ui.fragments.main.PopularListFragment
import com.pabji.androidappmovie.presentation.ui.fragments.main.di.FavoriteListModule
import com.pabji.androidappmovie.presentation.ui.fragments.main.di.PopularListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailFragmentsProvider {

    @ContributesAndroidInjector(modules = arrayOf(MovieInfoModule::class))
    internal abstract fun provideMovieInfoFragmentFactory(): MovieInfoFragment

    @ContributesAndroidInjector(modules = arrayOf(MovieImageModule::class))
    internal abstract fun provideMovieImageFragmentFactory(): MovieImageFragment
}