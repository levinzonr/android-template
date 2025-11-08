package com.levinzonr.template.android.features.resources.domain.repository

import com.levinzonr.template.android.features.resources.domain.model.Resource

interface ResourceRepository {
    suspend fun get(): List<Resource>
}
