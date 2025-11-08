package com.levinzonr.template.android.core.coordinator

interface Coordinator<T> {
    fun handle(action: T)
}
