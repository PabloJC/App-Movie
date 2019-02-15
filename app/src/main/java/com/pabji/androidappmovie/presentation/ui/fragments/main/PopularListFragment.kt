package com.pabji.androidappmovie.presentation.ui.fragments.main

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.domain.models.MoviePreview
import com.pabji.androidappmovie.presentation.base.view.BaseFragment
import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailActivity
import com.pabji.androidappmovie.presentation.ui.presenters.main.PopularListPresenter
import com.pabji.androidappmovie.presentation.ui.activities.main.MainActivity
import com.pabji.androidappmovie.presentation.ui.adapters.PopularListAdapter
import kotlinx.android.synthetic.main.fragment_popular_list.*
import javax.inject.Inject

class PopularListFragment: BaseFragment<PopularListContract.View, PopularListPresenter>(), PopularListContract.View {

    @Inject
    override lateinit var mPresenter : PopularListPresenter

    lateinit var adapter: PopularListAdapter

    companion object {
        fun newInstance (): PopularListFragment {
            return PopularListFragment()
        }
    }

    override fun getMyActivity(): AppCompatActivity {
        return activity as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        mPresenter.initialize()
    }

    private fun initView() {
        swipe_layout.setOnRefreshListener {
            mPresenter.initialize()
        }

        val orientation = activity?.resources?.configuration?.orientation

        var spanCount = 3
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 4
        }

        val layoutManager = GridLayoutManager(getMyActivity(),spanCount)

        rv_popularList.layoutManager = layoutManager

        rv_popularList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (swipe_layout.isRefreshing)
                    return
                val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
                if (pastVisibleItems + layoutManager.childCount >= layoutManager.itemCount) {
                    mPresenter.getPage()
                }
            }
        })

        adapter = PopularListAdapter { item ->
            run {
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra("movieId", item.id)
                startActivity(intent)
            }
        }
        rv_popularList.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_popular_list, container, false)
    }

    override fun resetList() {
        adapter.clearList()
        swipe_layout.isRefreshing = true
    }

    override fun showLoading() {
        swipe_layout.isRefreshing = true
    }

    override fun showMovieList(list: List<MoviePreview>) {
        swipe_layout.isRefreshing = false
        adapter.addData(list)
    }
}
