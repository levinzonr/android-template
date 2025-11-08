package com.levinzonr.template.android.features.resources.ui

import com.levinzonr.template.android.core.error.ErrorModel
import com.levinzonr.template.android.features.resources.domain.model.Resource

/**
 * UI State that represents ResourcesScreen
 **/
data class ResourcesState(
    val isLoading: Boolean = false,
    val resources: List<Resource> = emptyList(),
    val error: ErrorModel? = null,
)

/**
 * Resources Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class ResourcesActions(
    val onResourceClick: (Resource) -> Unit = {},
)
