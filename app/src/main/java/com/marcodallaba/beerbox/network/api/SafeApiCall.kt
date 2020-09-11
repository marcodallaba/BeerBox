package com.marcodallaba.beerbox.network.api

import com.marcodallaba.beerbox.utils.defaultMoshi
import com.marcodallaba.beerbox.utils.fromJson
import com.squareup.moshi.JsonDataException
import java.io.IOException
import java.net.SocketTimeoutException
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * This method wrap a Retrofit [Response] and handles properly all types of errors.
 * Without this wrapper you should surround with a try/catch every api call to avoid
 * unexpected crashes (no internet connection, timeout).
 *
 * @param block a suspend Retrofit call that returns a [Response]
 * @return a [NetworkResource] response.
 */
suspend inline fun <T, reified E : Any> safeApiCall(block: () -> Response<T>): NetworkResource<T, E> {
    val result = runCatching(block)
    return if (result.isSuccess) {
        val response = result.getOrNull()!!
        if (response.isSuccessful) {
            val responseBody = response.body()
            NetworkResource.Success<T, E>(response, responseBody)
        } else {
            val errorBody = response.errorBody()
            when (errorBody != null) {
                true -> NetworkResource.Error<T, E>(
                    response,
                    NetworkError.HttpError(response.code(), deserializeError(errorBody))
                )
                false -> NetworkResource.Error<T, E>(
                    response,
                    NetworkError.HttpError(response.code(), null)
                )
            }
        }
    } else {
        val exception = result.exceptionOrNull()
        exception?.printStackTrace()
        return when (exception) {
            is SocketTimeoutException -> NetworkResource.Error(null, NetworkError.Timeout())
            is IOException -> NetworkResource.Error(null, NetworkError.IOError())
            is JsonDataException -> {
                NetworkResource.Error(null, NetworkError.JsonParsingError(exception))
            }
            else -> NetworkResource.Error(null, NetworkError.Unknown())
        }
    }
}

/**
 * Deserialize an error response body using the specified [E] type.
 */
inline fun <reified E : Any> deserializeError(responseBody: ResponseBody): E? {
    val str = responseBody.string()
    val result = runCatching {
        defaultMoshi.fromJson<E>(str)
    }
    return if (result.isSuccess) result.getOrNull()!!
    else null
}
