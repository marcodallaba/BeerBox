package com.marcodallaba.beerbox.api.services

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PunkApiService {

    @GET("beers")
    suspend fun getBeers(@QueryMap options: Map<String, String>)

}

@JsonClass(generateAdapter = true)
data class Volume(
    @field:Json(name = "value") val value: Double,
    @field:Json(name = "unit") val unit: String
)


