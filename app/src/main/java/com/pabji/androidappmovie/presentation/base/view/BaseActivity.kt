package com.pabji.androidappmovie.presentation.ui.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pabji.androidappmovie.presentation.ui.base.presenter.BasePresenter
import dagger.android.support.DaggerAppCompatActivity

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<in V : BaseView, T : BasePresenter<V>>
    : DaggerAppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as V)
    }

    override fun getMyActivity(): AppCompatActivity {
        return this
    }
    abstract var mPresenter: T


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}