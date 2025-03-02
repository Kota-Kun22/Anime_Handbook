package com.example.anime_handbook.presentation.screens.splash

import android.content.res.Configuration
import android.window.SplashScreenView
import androidx.collection.emptyLongSet
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.anime_handbook.R
import com.example.anime_handbook.ui.theme.Purple500
import com.example.anime_handbook.ui.theme.Purple700
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val rotate= remember{Animatable(0f)}

    LaunchedEffect(key1 = true) {
        rotate.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis=1000, delayMillis = 200)
        )
    }



    Splash(rotate= rotate.value)
}

@Composable
fun Splash(rotate:Float)
{
    if(isSystemInDarkTheme())
    {
        Box(modifier= Modifier
            .background(Color.Black)
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier= Modifier.rotate(degrees = rotate),
                painter= painterResource(id =R.drawable.logo),
                contentDescription = stringResource(R.string.app_logo)
            )

        }

    }
    else
    {
        Box(modifier= Modifier
            .background(Brush.verticalGradient(listOf(Purple700, Purple500)))
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier= Modifier.rotate(degrees = rotate),
                painter= painterResource(id =R.drawable.logo),
                contentDescription = stringResource(R.string.app_logo))

        }

    }





}

@Preview
@Composable
fun SplashScreenPreview() {
    Splash(rotate = 0f)
    
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenView_DarkTheme()
{
    Splash(rotate = 0f)
}