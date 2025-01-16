package com.example.anime_handbook.DI

import android.content.Context
import androidx.core.content.contentValuesOf
import com.example.anime_handbook.data.pref.DataStoreOperationImpl
import com.example.anime_handbook.domain.repository.DataStoreOperations
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
}
