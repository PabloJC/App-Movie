package com.pabji.androidappmovie.presentation.ui.activities.detail

import com.pabji.androidappmovie.presentation.ui.presenters.detail.DetailPresenter
import com.pabji.androidappmovie.presentation.ui.presenters.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
abstract class DetailModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideMainPresenter(): DetailPresenter {
            return DetailPresenter()
        }
    }

}