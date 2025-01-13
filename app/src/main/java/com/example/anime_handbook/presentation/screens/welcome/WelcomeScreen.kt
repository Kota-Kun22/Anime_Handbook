package com.example.anime_handbook.presentation.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.anime_handbook.domain.model.OnBoardingPage
import com.example.anime_handbook.ui.theme.DarkGray
import com.example.anime_handbook.ui.theme.EXTRA_LARGE_PADDING
import com.example.anime_handbook.ui.theme.LightGray
import com.example.anime_handbook.ui.theme.SMALL_PADDING


@Composable
fun WelcomeScreen( navController: NavHostController)
{

    val isDarkTheme= isSystemInDarkTheme() //checking if the theme is dark or not
    val backgroundColor= if(isDarkTheme) Color.Black else Color.White
    val titleColor= if(isDarkTheme) LightGray else DarkGray
    val discriptionColor= if(isDarkTheme) LightGray.copy(alpha = 0.5f) else DarkGray.copy(alpha = 0.5f)

    val pages = listOf(OnBoardingPage.First,OnBoardingPage.Second,OnBoardingPage.Third)

    val pagerState= rememberPagerState(initialPage = 0){
        pages.size//Provide the total count dynamically
    }

    Column(
        modifier = Modifier
        .fillMaxSize()
        .background(color =backgroundColor)
    ){
        HorizontalPager(
            state = pagerState,
            modifier= Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){position->
            PagerScreen(onBoardingPage = pages[position],titleColor,desciptionColor= discriptionColor)

        }
    }

}
@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage, titleColor: Color,desciptionColor:Color)
{
    Column(modifier= Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top)
    {
        Image(
            modifier= Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f),
            painter= painterResource(id=onBoardingPage.image),
            contentDescription="Pager Image"
        )



        Text(
            modifier= Modifier.fillMaxWidth(),
            text= onBoardingPage.title,
            color = titleColor,
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )



        Text(
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top= SMALL_PADDING),
            text= onBoardingPage.discription,
            color = desciptionColor,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )

    }

}

@Composable
@Preview(showBackground = true)
fun FirstOnBoardingScreenPreview()
{
    Column(modifier=Modifier.fillMaxSize()){
      PagerScreen(onBoardingPage = OnBoardingPage.First, titleColor = DarkGray, desciptionColor = DarkGray)
    }
}

@Composable
@Preview(showBackground = true)
fun SecondOnBoardingScreenPreview()
{
    Column(modifier=Modifier.fillMaxSize()){
        PagerScreen(onBoardingPage = OnBoardingPage.Second, titleColor = DarkGray, desciptionColor = DarkGray)
    }
}

@Composable
@Preview(showBackground = true)
fun ThirdOnBoardingScreenPreview()
{
    Column(modifier=Modifier.fillMaxSize()){
        PagerScreen(onBoardingPage = OnBoardingPage.Third, titleColor = DarkGray, desciptionColor = DarkGray)
    }
}