package com.levinzonr.template.android.features.login.domain.usecase

import com.levinzonr.template.android.core.extensions.suspendRunCatching
import com.levinzonr.template.android.features.auth.domain.repository.AuthRepository
import com.levinzonr.template.android.features.user.domain.repository.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository,
) {

    suspend operator fun invoke(email: String, password: String) = suspendRunCatching {
        authRepository.login(email, password)
        userRepository.get()
    }
}
