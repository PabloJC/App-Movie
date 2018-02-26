package com.pabji.androidappmovie.domain.models

import com.pabji.androidappmovie.data.net.entities.GenreEntity

data class Movie(
        var adult: Boolean? = null,
        var backdropPath: String? = null,
        var budget: Int? = null,
        var genres: List<GenreEntity>? = null,
        var homepage: String? = null,
        var id: Int? = null,
        var imdbId: String? = null,
        var originalLanguage: String? = null,
        var originalTitle: String? = null,
        var overview: String? = null,
        var popularity: Double? = null,
        var posterPath: String? = null,
        var productionCompanies: List<String>? = null,
        var productionCountries: List<String>? = null,
        var releaseDate: String? = null,
        var spokenLanguages: List<String>? = null,
        var status: String? = null,
        var title: String? = null,
        var voteAverage: Double? = null,
        var voteCount: Int? = null)