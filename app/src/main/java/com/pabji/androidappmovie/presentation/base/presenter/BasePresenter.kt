package com.pabji.androidappmovie.presentation.base.presenter

import com.pabji.androidappmovie.presentation.base.view.BaseView

interface BasePresenter <in V : BaseView> {

    fun attachView(view: V)
    fun detachView()

}