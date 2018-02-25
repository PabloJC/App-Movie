package com.pabji.androidappmovie.data.net.entities

import com.squareup.moshi.Json

class SearchEntity {

    @Json(name = "page")
    var page: Int? = null
    @Json(name = "total_results")
    var totalResults: Int? = null
    @Json(name = "total_pages")
    var totalPages: Int? = null
    @Json(name = "results")
    var results: List<MoviePreviewEntity>? = null

}
