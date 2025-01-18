package com.example.anime_handbook.domain.use_cases.save_OnBoarding

import com.example.anime_handbook.data.repository.Repository

class SaveOnBoardingUseCase(private val repository: Repository) {

    suspend operator fun invoke(completed:Boolean)
    {
        repository.saveOnBoardingState(completed)

    }
}