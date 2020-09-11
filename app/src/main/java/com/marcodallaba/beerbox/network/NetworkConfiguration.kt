package com.marcodallaba.beerbox.network

import com.squareup.moshi.Moshi
import okhttp3.CertificatePinner
import okhttp3.Interceptor

/**
 * This is the networking configuration the app injects into this module
 * in order to customize it.
 */
interface NetworkConfiguration {
    fun baseUrl(): String
    fun certificatePinner(): CertificatePinner?
    fun interceptors(): List<Interceptor> = listOf()
    fun useCacheHeaders(): Boolean
    val moshi: Moshi
}
