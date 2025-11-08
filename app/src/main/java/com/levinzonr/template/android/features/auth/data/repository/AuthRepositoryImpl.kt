package com.levinzonr.template.android.features.auth.data.repository

import com.levinzonr.template.android.features.auth.data.api.AuthApi
import com.levinzonr.template.android.features.auth.data.api.dtos.toAuthToken
import com.levinzonr.template.android.features.auth.domain.models.AuthToken
import com.levinzonr.template.android.features.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
) : AuthRepository {

    override suspend fun login(email: String, password: String): AuthToken {
        val responseBody = api.postLogin(email, password)
        return responseBody.toAuthToken()
    }
}
