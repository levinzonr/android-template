package com.levinzonr.template.android.features.resources.data.repository

import com.levinzonr.template.android.features.resources.data.api.ResourcesApi
import com.levinzonr.template.android.features.resources.data.api.dtos.toResource
import com.levinzonr.template.android.features.resources.data.persistence.ResourcePreferenceStore
import com.levinzonr.template.android.features.resources.domain.model.Resource
import com.levinzonr.template.android.features.resources.domain.repository.ResourceRepository
import javax.inject.Inject

class ResourceRepositoryImpl @Inject constructor(
    private val api: ResourcesApi,
    private val resourcePreferenceStore: ResourcePreferenceStore,
) : ResourceRepository {

    override suspend fun get(): List<Resource> {
        return api.getResources().data.map { it.toResource() }.also {
            resourcePreferenceStore.addAll(it)
        }
    }
}
