package com.levinzonr.otterfinder.features.rescue.domain.usecase

import com.levinzonr.otterfinder.core.extensions.suspendRunCatching
import com.levinzonr.otterfinder.features.rescue.domain.models.Location
import com.levinzonr.otterfinder.features.rescue.domain.repository.RescuesRepository
import javax.inject.Inject

class GetRescuesAtLocationUseCase @Inject constructor(
    private val repository: RescuesRepository
) {

    suspend operator fun invoke(
        location: Location
    ) = suspendRunCatching {
        repository.get(location, 10)
    }
}