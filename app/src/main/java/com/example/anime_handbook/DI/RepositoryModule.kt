package com.example.anime_handbook.DI

import android.content.Context
import androidx.annotation.RequiresPermission
import com.example.anime_handbook.data.repository.DataStoreOperationImpl
import com.example.anime_handbook.data.repository.Repository
import com.example.anime_handbook.domain.repository.DataStoreOperations
import com.example.anime_handbook.domain.use_cases.UseCases
import com.example.anime_handbook.domain.use_cases.read_OnBoarding.ReadOnBoardingUseCase
import com.example.anime_handbook.domain.use_cases.save_OnBoarding.SaveOnBoardingUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperation(@ApplicationContext context: Context): DataStoreOperations {
        return DataStoreOperationImpl(context=context)

    }
    @Provides
    @Singleton
    fun provideUseCases(repository: Repository):UseCases
    {
        return UseCases(saveOnBoardingUseCase = SaveOnBoardingUseCase(repository), readOnBoardingUseCase = ReadOnBoardingUseCase(repository))
    }
}
