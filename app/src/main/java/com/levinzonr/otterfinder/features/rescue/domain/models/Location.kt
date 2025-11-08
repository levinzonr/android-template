package com.levinzonr.otterfinder.features.rescue.domain.models

data class Location(
    val latitude: Double,
    val longitude: Double
) {
    companion object {
        val Mock = Location(
            latitude = 45.0703, // Turin, Italy
            longitude = 7.6869
        )
    }
}