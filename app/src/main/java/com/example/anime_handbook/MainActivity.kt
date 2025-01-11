package com.example.anime_handbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.anime_handbook.navigation.SetupNavGraph
import com.example.anime_handbook.ui.theme.Anime_HandbookTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Anime_HandbookTheme {
                // A surface container using the 'background' color from the theme
                navController= rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

