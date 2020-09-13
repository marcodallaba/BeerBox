package com.marcodallaba.beerbox.ui.beers

import android.os.Parcelable
import com.marcodallaba.beerbox.util.BeerType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UIBeerItem(
    val id: Int,
    val name: String,
    val tagLine: String?,
    val description: String?,
    val imageUrl: String?,
    val beerType: BeerType
) : Parcelable