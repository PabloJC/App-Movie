package com.pabji.androidappmovie.presentation.ui.fragments.detail

import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.presentation.base.presenter.BaseFragmentPresenter
import com.pabji.androidappmovie.presentation.base.presenter.BasePresenter
import com.pabji.androidappmovie.presentation.base.view.BaseFragmentView

interface MovieInfoContract {

    interface View : BaseFragmentView {
    }

    interface Presenter : BasePresenter<View> {
    }
}