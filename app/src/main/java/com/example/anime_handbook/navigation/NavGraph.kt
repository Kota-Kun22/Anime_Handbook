package com.example.anime_handbook.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.anime_handbook.presentation.screens.splash.SplashScreen
import com.example.anime_handbook.presentation.screens.welcome.WelcomeScreen
import com.example.anime_handbook.utiles.Constants.DETAILS_ARGUMENTS_KEY

@Composable
fun SetupNavGraph(navController: NavHostController)
{ //setting up the navHost for the navigation
    NavHost(navController = navController, startDestination = Screen.Welcome.route)
    {
        composable(route = Screen.Splash.route)
        {
            SplashScreen(navController=navController)
        }

        composable(route = Screen.Welcome.route)
        {
            WelcomeScreen(navController = navController)

        }

        composable(route = Screen.Home.route)
        {

        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENTS_KEY) {
                type = NavType.IntType
            })
        )
        {

        }

        composable(route = Screen.Search.route){

        }

    }
}