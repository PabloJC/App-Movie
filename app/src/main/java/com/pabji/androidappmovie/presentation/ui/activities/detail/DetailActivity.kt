package com.pabji.androidappmovie.presentation.ui.activities.detail

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.presentation.base.view.BaseActivity
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieImageFragment
import com.pabji.androidappmovie.presentation.ui.fragments.detail.MovieInfoFragment
import com.pabji.androidappmovie.presentation.ui.presenters.detail.DetailPresenter
import com.pabji.androidappmovie.presentation.utils.extensions.addFragment
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast
import javax.inject.Inject


class DetailActivity : BaseActivity<DetailContract.View, DetailPresenter>(), DetailContract.View {

    @Inject
    override lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movieId = intent.getIntExtra("movieId",0)
        mPresenter.initialize(movieId,this)

        initView()
    }

    private fun initView() {

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        addFragment(MovieInfoFragment.newInstance(),R.id.content_info)

        val orientation = resources.configuration.orientation

        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            addFragment(MovieImageFragment.newInstance(),R.id.content_image)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        mPresenter.checkFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun showImage(backdropPath: String?) {
        Glide.with(this)
                .load("http://image.tmdb.org/t/p/w500"+backdropPath)
                .centerCrop()
                .into(iv_image)
    }

    override fun showTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun showSaved() {
        toast(getString(R.string.saved_favorite))
        isFavorite(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?)= when (item?.itemId) {

        R.id.action_favorite -> {
            mPresenter.saveFavorite()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun isFavorite(result: Boolean) {
        val item = toolbar.menu.findItem(R.id.action_favorite)

        if(result) {
            item.icon = ContextCompat.getDrawable(this,android.R.drawable.btn_star_big_on)
        }else{
            item.icon = ContextCompat.getDrawable(this,android.R.drawable.btn_star_big_off)
        }
    }
}

