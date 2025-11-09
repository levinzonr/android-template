package com.levinzonr.otterfinder.features.otters.injection

import com.levinzonr.otterfinder.features.otters.data.MockOttersRepository
import com.levinzonr.otterfinder.features.otters.domain.repository.OttersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRepository(): OttersRepository {
        return MockOttersRepository()
    }
}
