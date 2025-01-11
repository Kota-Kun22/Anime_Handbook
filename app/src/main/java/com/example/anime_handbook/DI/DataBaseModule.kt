package com.example.anime_handbook.DI

import android.content.Context
import androidx.room.Room
import com.example.anime_handbook.data.local.BorutoDatabase
import com.example.anime_handbook.utiles.Constants.HERO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context = context,
            klass = BorutoDatabase::class.java,
            name = HERO_DATABASE).build()
}