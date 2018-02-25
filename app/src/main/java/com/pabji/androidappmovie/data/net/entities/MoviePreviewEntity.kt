package com.pabji.androidappmovie.data.net.entities

import com.squareup.moshi.Json

class MoviePreviewEntity {

    @Json(name = "vote_count")
    var voteCount: Int? = null
    @Json(name = "id")
    var id: Int? = null
    @Json(name = "vote_average")
    var voteAverage: Double? = null
    @Json(name = "title")
    var title: String? = null
    @Json(name = "popularity")
    var popularity: Double? = null
    @Json(name = "poster_path")
    var posterPath: String? = null
    @Json(name = "original_language")
    var originalLanguage: String? = null
    @Json(name = "original_title")
    var originalTitle: String? = null
    @Json(name = "backdrop_path")
    var backdropPath: String? = null
    @Json(name = "adult")
    var adult: Boolean? = null
    @Json(name = "overview")
    var overview: String? = null
    @Json(name = "release_date")
    var releaseDate: String? = null

}