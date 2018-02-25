package com.pabji.androidappmovie.presentation.ui.main.views

import android.os.Bundle
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.presentation.base.view.BaseActivity
import com.pabji.androidappmovie.presentation.ui.main.presenters.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity<MainContract.View, MainPresenter>(), MainContract.View {

    @Inject
    override lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
