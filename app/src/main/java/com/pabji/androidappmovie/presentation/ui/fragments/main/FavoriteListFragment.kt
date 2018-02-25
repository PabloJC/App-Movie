package com.pabji.androidappmovie.presentation.ui.fragments.main

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.presentation.base.view.BaseFragment
import com.pabji.androidappmovie.presentation.ui.presenters.main.FavoriteListPresenter
import com.pabji.androidappmovie.presentation.ui.activities.main.MainActivity
import com.pabji.androidappmovie.presentation.ui.adapters.FavoriteListAdapter
import com.pabji.androidappmovie.presentation.ui.adapters.PopularListAdapter
import kotlinx.android.synthetic.main.fragment_popular_list.*
import javax.inject.Inject

class FavoriteListFragment: BaseFragment<FavoriteListContract.View, FavoriteListPresenter>(), FavoriteListContract.View {

    @Inject
    override lateinit var mPresenter : FavoriteListPresenter

    lateinit var adapter: FavoriteListAdapter

    companion object {
        fun newInstance (): FavoriteListFragment {
            return FavoriteListFragment()
        }
    }

    override fun getMyActivity(): AppCompatActivity {
        return activity as MainActivity
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        mPresenter.initialize()
    }

    private fun initView() {
        swipe_layout.setOnRefreshListener {
            mPresenter.initialize()
        }

        val orientation = activity.resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rv_popularList.layoutManager = GridLayoutManager(getMyActivity(),2)
        }else{
            rv_popularList.layoutManager = LinearLayoutManager(activity)
        }


        adapter = FavoriteListAdapter {
            mPresenter.openDetail()
        }
        rv_popularList.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_popular_list, container, false)
    }

    override fun showMovieList(list: List<MoviePreview>) {
        swipe_layout.isRefreshing = false
        adapter.addData(list)
    }
}