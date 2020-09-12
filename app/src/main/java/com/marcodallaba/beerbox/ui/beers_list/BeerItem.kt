package com.marcodallaba.beerbox.ui.beers_list

import android.os.Parcelable
import com.marcodallaba.beerbox.model.BeerType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BeerItem(
    val id: Long,
    val name: String,
    val tagLine: String?,
    val description: String?,
    val imageUrl: String?,
    val beerType: BeerType
) : Parcelable