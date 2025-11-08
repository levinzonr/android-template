package com.levinzonr.template.android.features.user.data.api.dtos

import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDTO(
    val data: UserDTO,
)
