package com.levinzonr.template.android.features.auth.domain.repository

import com.levinzonr.template.android.features.auth.domain.models.AuthToken

interface AuthRepository {
    suspend fun login(email: String, password: String): AuthToken
}
