package com.levinzonr.template.android.features.auth.injection

import com.levinzonr.template.android.features.auth.data.repository.AuthRepositoryImpl
import com.levinzonr.template.android.features.auth.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindAuthRepository(repositoryImpl: AuthRepositoryImpl): AuthRepository
}
