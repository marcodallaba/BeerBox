package com.marcodallaba.beerbox.network.api

import com.marcodallaba.beerbox.utils.DateUtils
import com.squareup.moshi.JsonDataException
import java.util.*
import retrofit2.Response

/**
 * A generic class that contains data and status about loading this data.
 *
 * @param T success response data type.
 * @param E error response data type.
 */
sealed class NetworkResource<T, E>(
    val data: T? = null,
    val error: NetworkError<E>? = null
) {
    class Success<T, E>(
        val response: Response<T>,
        data: T? = null
    ) : NetworkResource<T, E>(data = data) {
        val serverDate: Date?
            get() {
                val serverDateString = response.headers()["Date"] ?: return null
                return DateUtils.parseHttpDate(serverDateString)
            }
    }

    class Error<T, E>(val response: Response<T>?, error: NetworkError<E>) :
        NetworkResource<T, E>(error = error)
}

/**
 * A generic network error class.
 *
 * @param E error response data type.
 */
sealed class NetworkError<E> {
    class HttpError<E>(val httpCode: Int, val data: E?) : NetworkError<E>()
    class IOError<E> : NetworkError<E>()
    class Timeout<E> : NetworkError<E>()
    class Unknown<E> : NetworkError<E>()
    class JsonParsingError<E>(val exception: JsonDataException) : NetworkError<E>()
}
