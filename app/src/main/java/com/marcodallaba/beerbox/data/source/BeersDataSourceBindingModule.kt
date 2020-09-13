package com.marcodallaba.beerbox.data.source

import com.marcodallaba.beerbox.data.source.local.BeersLocalDataSource
import com.marcodallaba.beerbox.data.source.remote.BeersRemoteDataSource
import com.marcodallaba.beerbox.di.qualifier.LocalDataSource
import com.marcodallaba.beerbox.di.qualifier.RemoteDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class BeersDataSourceBindingModule {

    @Binds
    @RemoteDataSource
    abstract fun bindsBeersRemoteDataSource(beersRemoteDataSource: BeersRemoteDataSource): BeersDataSource


    @Binds
    @LocalDataSource
    abstract fun bindsBeersLocalDataSource(beersRemoteDataSource: BeersLocalDataSource): BeersDataSource

}