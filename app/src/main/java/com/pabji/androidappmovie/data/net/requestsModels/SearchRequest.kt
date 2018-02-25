package com.pabji.androidappmovie.data.net.requestsModels


data class SearchRequest(var api_key : String, var language : String? = "es", var page : Int? = 1){


    fun toQueryMap() : Map<String,String> {
        val data = hashMapOf<String, String>()
        data["api_key"] = api_key

        language?.let {
            data["language"] = it
        }

        page?.let {
            data["page"] = it.toString()
        }

        return data
    }
}
