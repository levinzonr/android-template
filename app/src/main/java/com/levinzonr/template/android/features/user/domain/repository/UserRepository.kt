package com.levinzonr.template.android.features.user.domain.repository

import com.levinzonr.template.android.features.user.domain.model.User

interface UserRepository {
    suspend fun get(): User
}
