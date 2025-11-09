package com.levinzonr.otterfinder.features.rescue.domain.repository

import com.levinzonr.otterfinder.core.location.Location
import com.levinzonr.otterfinder.features.rescue.domain.models.Rescue

interface RescuesRepository {
    suspend fun get(center: Location, radiusKm: Int) : List<Rescue>
}