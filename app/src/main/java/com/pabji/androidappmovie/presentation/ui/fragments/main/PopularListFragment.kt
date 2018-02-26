package com.pabji.androidappmovie.presentation.ui.fragments.main

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
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
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class PopularListFragment: BaseFragment<PopularListContract.View, PopularListPresenter>(), PopularListContract.View {
    override fun showSaved() {
        toast("Guardado")
    }

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

        var spanCount = 3
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 4
        }
        rv_popularList.layoutManager = GridLayoutManager(getMyActivity(),spanCount)


        adapter = PopularListAdapter {
            item -> startActivity(intentFor<DetailActivity>().newTask())
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

    override fun showMovieList(list: List<MoviePreview>) {
        swipe_layout.isRefreshing = false
        adapter.addData(list)
    }
}
