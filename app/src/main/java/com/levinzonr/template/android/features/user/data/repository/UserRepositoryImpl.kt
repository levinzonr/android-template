package com.levinzonr.template.android.features.user.data.repository

import com.levinzonr.template.android.features.user.data.api.UsersApi
import com.levinzonr.template.android.features.user.data.api.dtos.toUser
import com.levinzonr.template.android.features.user.data.persistence.UserPreferenceStore
import com.levinzonr.template.android.features.user.domain.model.User
import com.levinzonr.template.android.features.user.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UsersApi,
    private val userPreferenceStore: UserPreferenceStore,
) : UserRepository {

    override suspend fun get(): User {
        return api.getUser().data.toUser().also {
            userPreferenceStore.add(it)
        }
    }
}
