package com.pabji.androidappmovie.presentation.ui.main

import com.pabji.androidappmovie.presentation.ui.base.view.BaseActivity
import com.pabji.androidappmovie.presentation.ui.main.presenter.MainPresenter
import com.pabji.androidappmovie.presentation.ui.main.view.MainActivity
import com.pabji.androidappmovie.presentation.ui.main.view.MainContract
import dagger.Binds
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

    @Binds
    abstract fun provideMainActivity(mainActivity: MainActivity): BaseActivity<MainContract.View, MainPresenter>

}