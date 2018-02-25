package com.pabji.androidappmovie.presentation.base.view

import android.support.v4.app.Fragment

/**
 * Created by PabloJC on 25/2/18.
 */
interface BaseFragmentView: BaseView {
    fun getMyFragment(): Fragment
}