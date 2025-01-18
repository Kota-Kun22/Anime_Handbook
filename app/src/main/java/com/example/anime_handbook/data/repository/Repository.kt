package com.example.anime_handbook.data.repository

import com.example.anime_handbook.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository@Inject constructor(private val dataStore : DataStoreOperations) {

    suspend fun saveOnBoardingState(Complete :Boolean)
    {
        dataStore.saveOnBoardingState(Complete)
    }
    fun readOnBoardingState():Flow<Boolean>
    {
        return dataStore.readOnBoardingState()
    }
}