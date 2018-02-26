package com.pabji.androidappmovie.presentation.ui.fragments.detail

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.presentation.base.view.BaseFragment
import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailActivity
import com.pabji.androidappmovie.presentation.ui.presenters.detail.MovieInfoPresenter
import kotlinx.android.synthetic.main.fragment_info_detail.*
import kotlinx.android.synthetic.main.fragment_popular_list.*
import javax.inject.Inject

class MovieInfoFragment: BaseFragment<MovieInfoContract.View, MovieInfoPresenter>(), MovieInfoContract.View {

    @Inject
    override lateinit var mPresenter : MovieInfoPresenter

    companion object {
        fun newInstance (): MovieInfoFragment {
            return MovieInfoFragment()
        }
    }

    override fun getMyActivity(): AppCompatActivity {
        return activity as DetailActivity
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orientation = activity.resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rl_poster.visibility = View.GONE
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info_detail, container, false)
    }
}
