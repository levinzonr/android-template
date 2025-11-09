package com.levinzonr.otterfinder.features.rescue.domain.models

import com.levinzonr.otterfinder.core.location.Location
import com.levinzonr.otterfinder.features.otters.domain.models.Otter

data class Rescue(
    val id: String,
    val postedBy: Otter,
    val message: String,
    val location: Location,
    val type: RescueType,
)
