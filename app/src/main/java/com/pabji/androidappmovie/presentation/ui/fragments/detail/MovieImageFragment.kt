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
import kotlinx.android.synthetic.main.fragment_image_detail.*
import kotlinx.android.synthetic.main.item_main_list.view.*
import javax.inject.Inject

class MovieImageFragment : Fragment(){


    companion object {
        fun newInstance (): MovieImageFragment {

            val fragment = MovieImageFragment()
            val args = Bundle()
            args.putString("image","/7xQcmL6WWVJB8N0POzTqxXHf21Q.jpg")

            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = arguments.getString("image")
        Glide.with(activity)
                .load("http://image.tmdb.org/t/p/w185"+image)
                .centerCrop()
                .into(iv_image)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_detail, container, false)
    }
}