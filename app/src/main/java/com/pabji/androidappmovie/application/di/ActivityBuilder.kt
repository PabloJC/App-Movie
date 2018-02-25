package com.pabji.androidappmovie.application.di


import com.pabji.androidappmovie.presentation.ui.activities.main.MainModule
import dagger.Module
import com.pabji.androidappmovie.presentation.ui.activities.main.MainActivity
import com.pabji.androidappmovie.presentation.ui.fragments.main.di.MainFragmentsProvider
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(
            MainModule::class,
            MainFragmentsProvider::class))
    abstract fun MainActivity(): MainActivity

}