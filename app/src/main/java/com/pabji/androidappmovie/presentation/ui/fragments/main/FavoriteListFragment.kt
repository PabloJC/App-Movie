package com.pabji.androidappmovie.presentation.ui.fragments.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.presentation.base.view.BaseFragment
import com.pabji.androidappmovie.presentation.ui.presenters.main.FavoriteListPresenter
import com.pabji.androidappmovie.presentation.ui.activities.main.MainActivity
import javax.inject.Inject

class FavoriteListFragment: BaseFragment<FavoriteListContract.View, FavoriteListPresenter>(), FavoriteListContract.View {

    @Inject
    override lateinit var mPresenter : FavoriteListPresenter

    override fun getMyActivity(): AppCompatActivity {
        return activity as MainActivity
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.initialize()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite_list, container, false)
    }

    companion object {
        fun newInstance (): FavoriteListFragment {
            return FavoriteListFragment()
        }
    }
}