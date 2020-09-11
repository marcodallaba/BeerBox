package com.marcodallaba.beerbox.network.api

import android.content.Context
import android.util.Log
import com.squareup.moshi.Moshi
import com.marcodallaba.beerbox.network.NetworkConfiguration
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Initialize Retrofit type-safe HTTP API client.
 *
 * It uses some [Interceptor] for logging and gZip requests.
 * It uses certificate pinning for security reason.
 * It uses [Moshi] to serialize and deserialize JSON.
 */
class NetworkRetrofit(
    context: Context,
    config: NetworkConfiguration
) {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
    private val certificatePinner = config.certificatePinner()

    private val client by lazy {
        val builder = OkHttpClient.Builder()

        builder.addInterceptor(loggingInterceptor)

        certificatePinner?.let {
            builder.certificatePinner(it)
        }

        if (config.useCacheHeaders()) {
            val cacheSize = 2 * 1024 * 1024
            try {
                val cache = Cache(context.cacheDir, cacheSize.toLong())
                builder.cache(cache)
            } catch (e: Exception) {
                Log.d("NetworkRetrofit", "Unable to set OkHttp cache.")
            }
        }

        builder.build()
    }

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(config.baseUrl())
        .client(client)
        .addConverterFactory(
            MoshiConverterFactory.create(
                config.moshi
            )
        )
        .build()
}
