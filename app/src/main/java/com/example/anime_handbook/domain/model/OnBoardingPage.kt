package com.example.anime_handbook.domain.model

import androidx.annotation.DrawableRes
import com.example.anime_handbook.R

sealed class OnBoardingPage(

    @DrawableRes
    val image:Int,
    val title:String,
    val discription:String
) {
    object First:OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greetings",
        discription = "Are you a Anime fan? Because if you are then we have a great news for you!"
    )
    object Second:OnBoardingPage(
        image = R.drawable.explore,
        title = "Explore",
        discription = "Find your favorite animes and learn some of the things that you didn't know about."
    )
    object Third:OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        discription = "Check out your hero's power and see how much are they strong comparing to others."

    )

}