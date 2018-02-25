package com.pabji.androidappmovie.presentation.base.presenter

import com.pabji.androidappmovie.presentation.base.view.BaseFragmentView


open class BaseFragmentPresenter<V : BaseFragmentView> : BasePresenter<V> {

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }


    override fun detachView() {
        mView = null
    }
}