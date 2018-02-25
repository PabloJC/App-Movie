package com.pabji.androidappmovie.presentation.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.pabji.androidappmovie.presentation.ui.fragments.main.FavoriteListFragment
import com.pabji.androidappmovie.presentation.ui.fragments.main.PopularListFragment

class MainPageAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> {
                return PopularListFragment.newInstance()
            }
            1 -> {
                return FavoriteListFragment.newInstance()
            }
            else -> return null
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}