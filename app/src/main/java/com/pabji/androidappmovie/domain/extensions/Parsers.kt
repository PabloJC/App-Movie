package com.pabji.androidappmovie.domain.extensions

import com.pabji.androidappmovie.data.net.entities.MovieDetailEntity
import com.pabji.androidappmovie.data.net.entities.MoviePreviewEntity
import com.pabji.androidappmovie.data.persistence.entities.MovieRoomEntity
import com.pabji.androidappmovie.domain.models.Movie
import com.pabji.androidappmovie.domain.models.MoviePreview

fun List<MoviePreviewEntity>.previewEntityListToModelList() : List<MoviePreview> = this.map { it.previewEntityToModel() }

fun List<MovieRoomEntity>.roomEntityListToModelList() : List<MoviePreview> = this.map { it.roomEntityToModel() }

fun MoviePreviewEntity.previewEntityToModel() : MoviePreview = MoviePreview(id, voteAverage, title, popularity, posterPath, adult, releaseDate)

fun MovieRoomEntity.roomEntityToModel() : MoviePreview = MoviePreview(id, voteAverage, title, popularity, posterPath, adult, releaseDate)

fun Movie.modelToRoomEntity() : MovieRoomEntity = MovieRoomEntity(adult,backdropPath,budget,homepage,id,imdbId,originalLanguage,originalTitle,overview,popularity,posterPath,releaseDate,status,title,voteAverage,voteCount)

fun MovieDetailEntity.detailEntityToModel() : Movie = Movie(adult,backdropPath,budget,genres,homepage,id,imdbId,originalLanguage,originalTitle,overview,popularity,posterPath,productionCompanies?.map { it.name!! },productionCountries?.map { it.name!! },releaseDate,spokenLanguages?.map { it.name!! },status,title,voteAverage,voteCount)