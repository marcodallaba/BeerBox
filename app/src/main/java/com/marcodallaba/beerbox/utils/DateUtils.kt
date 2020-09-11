package com.marcodallaba.beerbox.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    const val MILLIS_IN_A_DAY = 24 * 60 * 60 * 1000

    fun parseHttpDate(date: String) = SimpleDateFormat(
        "EEE, dd MMM yyyy HH:mm:ss zzz",
        Locale.US
    ).parse(date)
}

fun Date.byAdding(
    days: Int = 0,
    hours: Int = 0,
    minutes: Int = 0,
    seconds: Int = 0,
    milliseconds: Int = 0,
    calendar: Calendar = Calendar.getInstance()
): Date {
    val date = this
    return calendar.apply {
        time = date
        if (days != 0) {
            add(Calendar.DAY_OF_YEAR, days)
        }
        if (hours != 0) {
            add(Calendar.HOUR_OF_DAY, hours)
        }
        if (minutes != 0) {
            add(Calendar.MINUTE, minutes)
        }
        if (seconds != 0) {
            add(Calendar.SECOND, seconds)
        }
        if (milliseconds != 0) {
            add(Calendar.MILLISECOND, milliseconds)
        }
    }.time
}

private val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)

val Date.isoDateString: String get() = dateFormatter.format(this)
