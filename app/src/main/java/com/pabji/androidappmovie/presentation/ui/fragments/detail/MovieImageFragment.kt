package com.pabji.androidappmovie.presentation.ui.fragments.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.presentation.base.view.BaseFragment
import com.pabji.androidappmovie.presentation.ui.activities.detail.DetailActivity
import com.pabji.androidappmovie.presentation.ui.presenters.detail.MovieImagePresenter
import com.pabji.androidappmovie.presentation.ui.presenters.detail.MovieInfoPresenter
import kotlinx.android.synthetic.main.fragment_image_detail.*
import kotlinx.android.synthetic.main.item_main_list.view.*
import javax.inject.Inject

class MovieImageFragment : BaseFragment<MovieImageContract.View, MovieImagePresenter>(), MovieImageContract.View {


    @Inject
    override lateinit var mPresenter : MovieImagePresenter

    companion object {
        fun newInstance (): MovieImageFragment {
            return MovieImageFragment()
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

    override fun showImage(image: String) {
        Glide.with(activity)
                .load("http://image.tmdb.org/t/p/w500$image")
                .centerCrop()
                .into(iv_image)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_detail, container, false)
    }
}