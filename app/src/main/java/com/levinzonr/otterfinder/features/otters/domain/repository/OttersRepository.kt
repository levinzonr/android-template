package com.levinzonr.otterfinder.features.otters.domain.repository

import com.levinzonr.otterfinder.features.otters.domain.models.Otter
import kotlinx.coroutines.flow.Flow

interface OttersRepository {
    fun observe() : Flow<List<Otter>>
}