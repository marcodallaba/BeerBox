package com.marcodallaba.beerbox.ui.beers

import com.marcodallaba.beerbox.util.BeerType
import java.io.Serializable

data class UIBeerItem(
    val id: Int,
    val name: String,
    val tagLine: String?,
    val description: String?,
    val imageUrl: String?,
    val beerType: BeerType
) : Serializable