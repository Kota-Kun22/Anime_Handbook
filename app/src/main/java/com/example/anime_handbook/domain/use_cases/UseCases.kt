package com.example.anime_handbook.domain.use_cases

import com.example.anime_handbook.domain.use_cases.read_OnBoarding.ReadOnBoardingUseCase
import com.example.anime_handbook.domain.use_cases.save_OnBoarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase:SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
    )



