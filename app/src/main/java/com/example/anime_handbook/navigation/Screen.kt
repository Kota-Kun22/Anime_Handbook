package com.example.anime_handbook.navigation

 sealed class Screen(val route:String) {
      object Splash : Screen("splash_screen")
      object Welcome : Screen("welcome_screen")
      object Home : Screen("home_screen")
      object Details : Screen("details_screen/{heroId}") //required and optional arguments
     {
         fun passHeroId(heroId:Int):String
         {
             return "details_screen/$heroId"
         }
     }
     data object Search : Screen("search_screen")


 }