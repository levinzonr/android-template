package com.levinzonr.otterfinder.core.coordinator

interface Coordinator<T> {
    fun handle(action: T)
}
