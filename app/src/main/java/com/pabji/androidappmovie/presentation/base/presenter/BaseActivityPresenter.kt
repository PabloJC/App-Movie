package com.pabji.androidappmovie.presentation.base.presenter

import com.pabji.androidappmovie.presentation.base.view.BaseView

open class BaseActivityPresenter < V : BaseView> : BasePresenter<V> {

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}