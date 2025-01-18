package com.example.anime_handbook.domain.use_cases.read_OnBoarding

import com.example.anime_handbook.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    operator fun invoke(): Flow<Boolean>
    {
        return repository.readOnBoardingState()
    }
}