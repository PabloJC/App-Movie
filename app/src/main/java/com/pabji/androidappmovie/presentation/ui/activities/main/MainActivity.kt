package com.pabji.androidappmovie.presentation.ui.activities.main

import android.os.Bundle
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.presentation.base.view.BaseActivity
import com.pabji.androidappmovie.presentation.ui.adapters.MainPageAdapter
import com.pabji.androidappmovie.presentation.ui.presenters.main.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.support.design.widget.TabLayout



class MainActivity : BaseActivity<MainContract.View, MainPresenter>(), MainContract.View {

    @Inject
    override lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        setSupportActionBar(toolbar)

        tab_layout.addTab(tab_layout.newTab().setText(getString(R.string.tab_title_popular_movies)))
        tab_layout.addTab(tab_layout.newTab().setText(getString(R.string.tab_title_favorites_movies)))

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    pager.currentItem = it.position
                }
            }
        })
        pager.adapter = MainPageAdapter(supportFragmentManager,tab_layout.tabCount)
    }
}
