package com.levinzonr.otterfinder.core.extensions

import kotlin.time.Duration
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun tickerFlow(interval: Duration, initialDelay: Duration = Duration.ZERO): Flow<Unit> {
    return flow {
        delay(initialDelay)
        while (true) {
            emit(Unit)
            delay(interval)
        }
    }
}

fun <T> Flow<T>.onFirst(block: (T) -> Unit): Flow<T> {
    return flow {
        var isFirstConsumed = false
        collect { value ->
            if (!isFirstConsumed) {
                block(value)
                isFirstConsumed = true
            }
            emit(value)
        }
    }
}
