package com.levinzonr.template.android.core.network.errorhandling

import kotlinx.serialization.Serializable

@Serializable
data class ApiErrorDTO(val error: String)

fun ApiErrorDTO.toApiError(code: Int) = ApiException(code, error)
