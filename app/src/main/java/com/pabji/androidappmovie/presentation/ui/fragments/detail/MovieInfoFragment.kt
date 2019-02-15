package com.pabji.androidappmovie.presentation.ui.fragments.detail

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.domain.models.Movie
import com.pabji.androidappmovie.presentation.base.view.BaseFragment
import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailActivity
import com.pabji.androidappmovie.presentation.ui.presenters.detail.MovieInfoPresenter
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_info_detail.*
import javax.inject.Inject

class MovieInfoFragment: BaseFragment<MovieInfoContract.View, MovieInfoPresenter>(), MovieInfoContract.View {

    override fun showTitle(title: String?) {
        tv_originalTitle.text = title
    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.apply {
            mPresenter.initialize(this)
        }
    }

    override fun showData(movie: Movie) {
        getMyActivity().supportActionBar?.title = movie.title
        tv_originalTitle.text = movie.originalTitle
        tv_overview.text = movie.overview
    }

    override fun showGenres(joinToString: String?) {
        tv_genres.text = joinToString
    }

    override fun showBudget(budget: String) {
        tv_budget.text = budget
    }

    override fun showDate(date: String){
        tv_release_date.text = date
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info_detail, container, false)
    }
}
