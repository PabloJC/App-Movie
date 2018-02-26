package com.pabji.androidappmovie.presentation.ui.activities.detail

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.presentation.base.view.BaseActivity
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieImageFragment
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieInfoFragment
import com.pabji.androidappmovie.presentation.ui.presenters.detail.DetailPresenter
import com.pabji.androidappmovie.presentation.utils.extensions.addFragment
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject


class DetailActivity : BaseActivity<DetailContract.View, DetailPresenter>(), DetailContract.View {

    @Inject
    override lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mPresenter.initialize(this)

        initView()
    }

    private fun initView() {

        setSupportActionBar(toolbar)
        toolbar?.setPadding(0, getStatusBarHeight(), 0, 0);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        addFragment(MovieInfoFragment.newInstance(),R.id.content_info)

        val orientation = resources.configuration.orientation

        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            supportActionBar?.setDisplayShowTitleEnabled(false)
            addFragment(MovieImageFragment.newInstance(),R.id.content_image)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?)= when (item?.itemId) {

        R.id.action_favorite -> {
            mPresenter.saveFavorite()
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}

