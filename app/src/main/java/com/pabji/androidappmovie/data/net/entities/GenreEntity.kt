package com.pabji.androidappmovie.data.net.entities

import com.squareup.moshi.Json


class GenreEntity {
    @Json(name = "id")
    var id: Int? = null
    @Json(name = "name")
    var name: String? = null

}