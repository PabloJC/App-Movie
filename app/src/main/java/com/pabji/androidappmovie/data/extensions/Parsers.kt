package com.pabji.androidappmovie.data.net.extensions

import com.pabji.androidappmovie.data.net.entities.MoviePreviewEntity
import com.pabji.androidappmovie.data.net.models.MoviePreview

fun List<MoviePreviewEntity>.toModelList() : List<MoviePreview> = this.map {
    MoviePreview(it.id,it.voteAverage,it.title,it.popularity,it.posterPath,it.adult,it.releaseDate)
}