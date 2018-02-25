package com.pabji.androidappmovie.presentation.ui.base.presenter

import com.pabji.androidappmovie.presentation.ui.base.view.BaseView


interface BasePresenter <in V : BaseView> {

    fun attachView(view: V)
    fun detachView()

}