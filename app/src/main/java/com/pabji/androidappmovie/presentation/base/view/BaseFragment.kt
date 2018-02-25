package com.pabji.androidappmovie.presentation.base.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import dagger.android.support.DaggerFragment

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<V : BaseFragmentView, T : BaseFragmentPresenter<V>>
    : DaggerFragment(), BaseFragmentView {


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.attachView(this as V )
    }

    override fun getMyFragment(): Fragment {
        return this
    }

    abstract var mPresenter: T
    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}