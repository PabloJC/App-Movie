package com.pabji.androidappmovie.domain.models

data class MoviePreview (
    var id: Int? = null,
    var voteAverage: Double? = null,
    var title: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var adult: Boolean? = null,
    var releaseDate: String? = null)

