package com.marcodallaba.beerbox.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marcodallaba.beerbox.data.Beer

@Dao
interface BeersDao {

    @Query("SELECT * FROM beer")
    fun getBeers(): LiveData<List<Beer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBeers(beers: List<Beer>)

}