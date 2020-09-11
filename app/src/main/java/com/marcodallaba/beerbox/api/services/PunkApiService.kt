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
data class Beers(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "tagline") val tagline: String,
    @field:Json(name = "first_brewed") val first_brewed: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "image_url") val image_url: String,
    @field:Json(name = "abv") val abv: Double,
    @field:Json(name = "ibu") val ibu: Double,
    @field:Json(name = "target_fg") val target_fg: Double,
    @field:Json(name = "target_og") val target_og: Double,
    @field:Json(name = "ebc") val ebc: Double,
    @field:Json(name = "srm") val srm: Double,
    @field:Json(name = "ph") val ph: Double,
    @field:Json(name = "attenuation_level") val attenuation_level: Double,
    @field:Json(name = "volume") val volume: Volume,
    @field:Json(name = "boil_volume") val boil_volume: Volume,
    @field:Json(name = "food_pairing") val food_pairing: List<String>,
    @field:Json(name = "brewers_tips") val brewers_tips: String
)

@JsonClass(generateAdapter = true)
data class Volume(
    @field:Json(name = "value") val value: Double,
    @field:Json(name = "unit") val unit: String
)


