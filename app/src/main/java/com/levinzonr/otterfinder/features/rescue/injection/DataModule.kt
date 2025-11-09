package com.levinzonr.otterfinder.features.rescue.injection

import com.levinzonr.otterfinder.features.otters.domain.repository.OttersRepository
import com.levinzonr.otterfinder.features.rescue.data.RescuesRepositoryImpl
import com.levinzonr.otterfinder.features.rescue.domain.repository.RescuesRepository
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
    fun provideRepository(ottersRepository: OttersRepository): RescuesRepository {
        return RescuesRepositoryImpl(ottersRepository)
    }
}
