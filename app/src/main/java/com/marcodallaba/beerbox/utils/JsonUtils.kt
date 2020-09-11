package com.marcodallaba.beerbox.utils

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.InputStream
import java.nio.charset.Charset
import java.util.*
import kotlin.reflect.KClass

private fun Moshi.Builder.addBaseAdapters(): Moshi.Builder {
    add(KotlinJsonAdapterFactory())
    add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
    return this
}

val defaultMoshi: Moshi = Moshi.Builder().addBaseAdapters().build()

fun moshi(
    extraAdapters: Map<KClass<*>, JsonAdapter<*>> = mapOf(),
    extraFactories: List<JsonAdapter.Factory> = listOf()
): Moshi = Moshi.Builder().apply {
    extraAdapters.forEach { add(it.key.java, it.value) }
    extraFactories.forEach { add(it) }
    addBaseAdapters()
}.build()

inline fun <reified T : Any> Moshi.toJson(
    obj: T
): String {
    val jsonAdapter = adapter(T::class.java)
    return jsonAdapter.toJson(obj)
}

fun <T : Any> Moshi.toJson(
    objectClass: KClass<T>,
    obj: T
): String {
    val jsonAdapter = adapter(objectClass.java)
    return jsonAdapter.toJson(obj)
}

inline fun <reified T : Any> Moshi.fromJson(
    json: String,
    lenient: Boolean = false
): T? {
    var jsonAdapter = adapter(T::class.java)
    if (lenient) {
        jsonAdapter = jsonAdapter.lenient()
    }
    return jsonAdapter.fromJson(json)
}

fun <T : Any> Moshi.fromJson(
    objectClass: KClass<T>,
    json: String,
    lenient: Boolean = false
): T? {
    var jsonAdapter = adapter(objectClass.java)
    if (lenient) {
        jsonAdapter = jsonAdapter.lenient()
    }
    return jsonAdapter.fromJson(json)
}

fun loadJsonAsset(context: Context, path: String): String? {
    var ins: InputStream? = null
    try {
        ins = context.assets.open(path)
        val size = ins.available()
        val buffer = ByteArray(size)
        ins.read(buffer)
        return String(buffer, Charset.forName("UTF-8"))
    } catch (e: Exception) {
        return null
    } finally {
        ins?.close()
    }
}
