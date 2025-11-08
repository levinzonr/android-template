package com.levinzonr.otterfinder.core.persistence

interface DataSource<T> {
    suspend fun getAll(): List<T>
    suspend fun add(item: T)
    suspend fun addAll(items: List<T>)
    suspend fun clear()
}
