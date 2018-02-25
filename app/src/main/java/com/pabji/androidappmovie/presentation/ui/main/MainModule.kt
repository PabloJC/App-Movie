package com.pabji.androidappmovie.presentation.ui.main

import com.pabji.androidappmovie.presentation.ui.main.presenter.MainPresenter
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