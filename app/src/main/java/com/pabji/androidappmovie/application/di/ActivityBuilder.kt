package com.pabji.androidappmovie.application.di


import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailActivity
import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailModule
import com.pabji.androidappmovie.presentation.ui.activities.main.MainModule
import dagger.Module
import com.pabji.androidappmovie.presentation.ui.activities.main.MainActivity
import com.pabji.androidappmovie.presentation.ui.fragments.detail.di.DetailFragmentsProvider
import com.pabji.androidappmovie.presentation.ui.fragments.detail.di.MovieInfoModule
import com.pabji.androidappmovie.presentation.ui.fragments.main.di.MainFragmentsProvider
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(
            MainModule::class,
            MainFragmentsProvider::class))
    abstract fun MainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(
            DetailModule::class,
            DetailFragmentsProvider::class))
    abstract fun DetailActivity(): DetailActivity

}