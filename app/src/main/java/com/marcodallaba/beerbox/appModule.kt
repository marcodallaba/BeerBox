package com.marcodallaba.beerbox

import com.marcodallaba.beerbox.api.services.PunkApiService
import com.marcodallaba.beerbox.config.BeerBoxNetworkConfiguration
import com.marcodallaba.beerbox.network.Network
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Dependency Injection Koin module.
 */
val appModule = module {

    /**
     * Exposure Ingestion Service APIs
     */
    single {
        val network = Network(
            androidContext(),
            BeerBoxNetworkConfiguration(
                androidContext(),
                get()
            )
        )
        network.createServiceAPI(PunkApiService::class)
    }
}