package com.pabji.androidappmovie.data.net.entities

import com.squareup.moshi.Json

class ProductionCompanyEntity {

    @Json(name = "name")
    var name: String? = null
    @Json(name = "id")
    var id: Int? = null

}