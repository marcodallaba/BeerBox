package com.marcodallaba.beerbox.config

import android.content.Context
import com.marcodallaba.beerbox.R
import com.marcodallaba.beerbox.network.NetworkConfiguration
import com.squareup.moshi.Moshi
import okhttp3.CertificatePinner

abstract class BaseNetworkConfiguration(
    val context: Context,
    override val moshi: Moshi
) : NetworkConfiguration {

    override fun certificatePinner(): CertificatePinner? {
        return CertificatePinner.Builder()
            .add(
                context.getString(R.string.base_url),
                context.getString(R.string.certificate_pinning_sha256)
            ).build()
    }

    override fun useCacheHeaders() = false
}
