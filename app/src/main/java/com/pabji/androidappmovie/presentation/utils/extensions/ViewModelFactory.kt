package com.pabji.androidappmovie.presentation.utils.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pabji.androidappmovie.presentation.ui.viewModels.MovieDetailViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
@Singleton
class ViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {
            val key = "MainViewModel"
            if(hashMapViewModel.containsKey(key)){
                return getViewModel(key) as T
            } else {
                addViewModel(key, MovieDetailViewModel())
                return getViewModel(key) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    companion object {
        val hashMapViewModel = HashMap<String, ViewModel>()
        fun addViewModel(key: String, viewModel: ViewModel){
            hashMapViewModel.put(key, viewModel)
        }
        fun getViewModel(key: String): ViewModel? {
            return hashMapViewModel[key]
        }
    }
}