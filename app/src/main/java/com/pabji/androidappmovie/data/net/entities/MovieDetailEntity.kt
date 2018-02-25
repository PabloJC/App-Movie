package com.pabji.androidappmovie.data.net.entities

import com.squareup.moshi.Json


class MovieDetailEntity {
    @Json(name = "adult")
    var adult: Boolean? = null
    @Json(name = "backdrop_path")
    var backdropPath: String? = null
    @Json(name = "budget")
    var budget: Int? = null
    @Json(name = "genres")
    var genres: List<GenreEntity>? = null
    @Json(name = "homepage")
    var homepage: String? = null
    @Json(name = "id")
    var id: Int? = null
    @Json(name = "imdb_id")
    var imdbId: String? = null
    @Json(name = "original_language")
    var originalLanguage: String? = null
    @Json(name = "original_title")
    var originalTitle: String? = null
    @Json(name = "overview")
    var overview: String? = null
    @Json(name = "popularity")
    var popularity: Double? = null
    @Json(name = "poster_path")
    var posterPath: String? = null
    @Json(name = "production_companies")
    var productionCompanies: List<ProductionCompanyEntity>? = null
    @Json(name = "production_countries")
    var productionCountries: List<ProductionCountryEntity>? = null
    @Json(name = "release_date")
    var releaseDate: String? = null
    @Json(name = "spoken_languages")
    var spokenLanguages: List<SpokenLanguageEntity>? = null
    @Json(name = "status")
    var status: String? = null
    @Json(name = "tagline")
    var tagline: String? = null
    @Json(name = "title")
    var title: String? = null
    @Json(name = "video")
    var video: Boolean? = null
    @Json(name = "vote_average")
    var voteAverage: Double? = null
    @Json(name = "vote_count")
    var voteCount: Int? = null
}