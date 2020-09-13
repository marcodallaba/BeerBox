package com.marcodallaba.beerbox.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.GenericLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.*
import androidx.lifecycle.Lifecycle.State.*
import androidx.lifecycle.LifecycleOwner
import io.reactivex.disposables.Disposable

fun Disposable.bindToLifecycle(lifecycleOwner: LifecycleOwner): Disposable {
    val lifecycle = ((lifecycleOwner as? Fragment)?.viewLifecycleOwner ?: lifecycleOwner).lifecycle
    val subscriptionState = lifecycle.currentState
    lifecycle.addObserver(GenericLifecycleObserver { _, e ->
        if (shouldDispose(subscriptionState, e))
            try {
                dispose()
            } catch (_: Exception) {
            }
    })
    return this
}

private fun shouldDispose(subscriptionState: Lifecycle.State, stateEvent: Lifecycle.Event?) = when (stateEvent) {
    ON_PAUSE -> subscriptionState == STARTED || subscriptionState == RESUMED
    ON_STOP -> subscriptionState == CREATED
    ON_DESTROY -> true
    else -> false
}
