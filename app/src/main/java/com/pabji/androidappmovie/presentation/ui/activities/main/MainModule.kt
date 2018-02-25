package com.pabji.androidappmovie.presentation.ui.activities.main

import com.pabji.androidappmovie.presentation.ui.presenters.main.MainPresenter
import dagger.Module
import dagger.Provides


@Module
abstract class MainModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideMainPresenter(): MainPresenter {
            return MainPresenter()
        }
    }

}