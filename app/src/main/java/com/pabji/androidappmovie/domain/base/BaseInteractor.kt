package com.pabji.androidappmovie.domain.interactors.base

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseInteractor<T>{

    protected open var observable : Observable<T>? = null

    fun runObserver(observer : Observer<T>) {
        observable?.let {
            it.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer)
        }
    }
}
