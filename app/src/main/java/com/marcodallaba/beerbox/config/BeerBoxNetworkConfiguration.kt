package com.marcodallaba.beerbox.config

import android.content.Context
import com.marcodallaba.beerbox.R
import com.squareup.moshi.Moshi

class BeerBoxNetworkConfiguration(
    context: Context, override val moshi: Moshi
) : BaseNetworkConfiguration(context, moshi) {

    override fun baseUrl(): String {
        return context.getString(R.string.base_url)
    }
}