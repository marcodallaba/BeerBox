package com.marcodallaba.beerbox.api

import com.marcodallaba.beerbox.network.api.safeApiCall
import retrofit2.Response

suspend inline fun <T> apiCall(block: () -> Response<T>) = safeApiCall<T, ErrorResponse>(block)
