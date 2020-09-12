package com.marcodallaba.beerbox.utils.view

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Context.getColorCompat(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)
