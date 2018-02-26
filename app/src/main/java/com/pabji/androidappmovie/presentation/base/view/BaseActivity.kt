package com.pabji.androidappmovie.presentation.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pabji.androidappmovie.presentation.base.presenter.BasePresenter
import dagger.android.support.DaggerAppCompatActivity
import android.support.v4.view.ViewCompat.setFitsSystemWindows
import android.view.ViewGroup
import android.os.Build
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewCompat.getFitsSystemWindows
import android.view.View
import android.view.WindowManager




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

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}