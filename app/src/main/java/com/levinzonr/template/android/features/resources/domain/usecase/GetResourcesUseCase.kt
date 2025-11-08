package com.levinzonr.template.android.features.resources.domain.usecase

import com.levinzonr.template.android.core.extensions.suspendRunCatching
import com.levinzonr.template.android.features.resources.domain.repository.ResourceRepository
import javax.inject.Inject
import kotlinx.coroutines.delay

class GetResourcesUseCase @Inject constructor(
    private val resourceRepository: ResourceRepository,
) {

    suspend operator fun invoke() = suspendRunCatching {
        delay(2000)
        resourceRepository.get()
    }
}
