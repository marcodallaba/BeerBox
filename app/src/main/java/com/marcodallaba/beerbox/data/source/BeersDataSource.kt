package com.marcodallaba.beerbox.data.source

import androidx.lifecycle.LiveData
import com.marcodallaba.beerbox.data.Beer
import com.marcodallaba.beerbox.util.BeerType
import io.reactivex.Single

interface BeersDataSource {

    fun getBeers(page: Int, perPage: Int): Single<List<Beer>>?

    fun insertBeers(beers: List<Beer>)

    fun getBeers(): LiveData<List<Beer>>?

    fun getBeerTypes(): List<BeerType>?
}