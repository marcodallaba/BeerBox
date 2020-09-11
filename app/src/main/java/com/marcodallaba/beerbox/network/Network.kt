package com.marcodallaba.beerbox.network

import android.content.Context
import com.marcodallaba.beerbox.network.api.NetworkRetrofit
import kotlin.reflect.KClass

/**
 * Network module entry point.
 */
class Network(
    val context: Context,
    private val config: NetworkConfiguration
) {

    /**
     * Creates an instance of [apiClass]
     * using the [Network] and [NetworkConfiguration] config.
     */
    fun <T : Any> createServiceAPI(apiClass: KClass<T>): T {
        return NetworkRetrofit(context, config).retrofit.create(
            apiClass.java
        )
    }
}
