package com.pabji.androidappmovie.presentation.ui.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pabji.androidappmovie.domain.models.Movie
import com.pabji.androidappmovie.domain.models.MoviePreview

class MovieDetailViewModel : ViewModel() {

    var currentMovie = MutableLiveData<Movie>()
    fun getCurrentMovie(): LiveData<Movie> {
        if (currentMovie.value == null){
            currentMovie.value = Movie()
        }
        return currentMovie
    }

    fun setCurrentUser(movie: Movie){
        currentMovie.value = movie
    }

}