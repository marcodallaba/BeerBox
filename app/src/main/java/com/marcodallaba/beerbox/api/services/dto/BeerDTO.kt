package com.marcodallaba.beerbox.api.services.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Beer(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "tagline") val tagLine: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "image_url") val imageUrl: String,
    @field:Json(name = "ebc") val ebc: Double
)