package com.pabji.androidappmovie.application.di


import com.pabji.androidappmovie.presentation.ui.main.MainModule
import dagger.Module
import com.pabji.androidappmovie.presentation.ui.main.view.MainActivity
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun MainActivity(): MainActivity

}