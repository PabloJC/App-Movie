package com.pabji.androidappmovie.presentation.ui.main.views.fragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.presentation.base.view.BaseFragment
import com.pabji.androidappmovie.presentation.ui.main.presenters.fragments.PopularListPresenter
import com.pabji.androidappmovie.presentation.ui.main.views.MainActivity
import javax.inject.Inject

class PopularListFragment: BaseFragment<PopularListContract.View, PopularListPresenter>(), PopularListContract.View {

    @Inject
    override lateinit var mPresenter : PopularListPresenter

    override fun getMyActivity(): AppCompatActivity {
        return activity as MainActivity
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.initialize()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_popular_list, container, false)
    }

    companion object {
        fun newInstance (): PopularListFragment {
            return PopularListFragment()
        }
    }
}
