package com.pabji.androidappmovie.domain.models

import com.pabji.androidappmovie.data.net.entities.GenreEntity

data class Movie(
        var adult: Boolean?,
        var backdropPath: String?,
        var budget: Int?,
        var genres: List<GenreEntity>?,
        var homepage: String?,
        var id: Int?,
        var imdbId: String?,
        var originalLanguage: String?,
        var originalTitle: String?,
        var overview: String?,
        var popularity: Double?,
        var posterPath: String?,
        var productionCompanies: List<String>?,
        var productionCountries: List<String>?,
        var releaseDate: String?,
        var spokenLanguages: List<String>?,
        var status: String?,
        var title: String?,
        var voteAverage: Double?,
        var voteCount: Int?)