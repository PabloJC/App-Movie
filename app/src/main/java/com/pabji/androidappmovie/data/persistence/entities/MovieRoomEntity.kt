package com.pabji.androidappmovie.data.persistence.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieRoomEntity(
        @ColumnInfo(name = "adult") var adult: Boolean?,
        @ColumnInfo(name = "backdropPath") var backdropPath: String?,
        @ColumnInfo(name = "budget") var budget: Int?,
        @ColumnInfo(name = "homepage")var homepage: String?,
        @ColumnInfo(name = "id") @PrimaryKey() var id: Int?,
        @ColumnInfo(name = "imdbId") var imdbId: String?,
        @ColumnInfo(name = "originalLanguage")var originalLanguage: String?,
        @ColumnInfo(name = "originalTitle")var originalTitle: String?,
        @ColumnInfo(name = "overview")var overview: String?,
        @ColumnInfo(name = "popularity")var popularity: Double?,
        @ColumnInfo(name = "posterPath")var posterPath: String?,
        @ColumnInfo(name = "releaseDate")var releaseDate: String?,
        @ColumnInfo(name = "status")var status: String?,
        @ColumnInfo(name = "title")var title: String?,
        @ColumnInfo(name = "voteAverage")var voteAverage: Double?,
        @ColumnInfo(name = "voteCount")var voteCount: Int?)