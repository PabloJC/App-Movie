package com.pabji.androidappmovie.data.extensions

import com.pabji.androidappmovie.data.net.entities.MoviePreviewEntity
import com.pabji.androidappmovie.data.persistence.entities.MovieRoomEntity
import com.pabji.androidappmovie.domain.models.MoviePreview

fun List<MoviePreviewEntity>.previewEntityListToModelList() : List<MoviePreview> = this.map { it.previewEntityToModel() }

fun List<MovieRoomEntity>.roomEntityListToModelList() : List<MoviePreview> = this.map { it.roomEntityToModel() }

fun MoviePreviewEntity.previewEntityToModel() : MoviePreview = MoviePreview(id, voteAverage, title, popularity, posterPath, adult, releaseDate)

fun MovieRoomEntity.roomEntityToModel() : MoviePreview = MoviePreview(id, voteAverage, title, popularity, posterPath, adult, releaseDate)

fun MoviePreview.modelToRoomEntity() : MovieRoomEntity = MovieRoomEntity(null,null,null,null,id,null,null,null,null,popularity,posterPath,releaseDate,null,title,voteAverage,null)
