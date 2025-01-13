package com.example.anime_handbook.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.anime_handbook.domain.model.OnBoardingPage
import com.example.anime_handbook.ui.theme.DarkGray
import com.example.anime_handbook.ui.theme.EXTRA_LARGE_PADDING
import com.example.anime_handbook.ui.theme.LightGray
import com.example.anime_handbook.ui.theme.PAGING_INDICATOR_SPACING
import com.example.anime_handbook.ui.theme.PAGING_INDICATOR_WIDTH
import com.example.anime_handbook.ui.theme.Purple500
import com.example.anime_handbook.ui.theme.Purple700
import com.example.anime_handbook.ui.theme.SMALL_PADDING

@Composable
fun WelcomeScreen(navController: NavHostController) {
    val isDarkTheme = isSystemInDarkTheme()
    val backgroundColor = if (isDarkTheme) Color.Black else Color.White
    val titleColor = if (isDarkTheme) LightGray else DarkGray
    val descriptionColor = if (isDarkTheme) LightGray.copy(alpha = 0.5f) else DarkGray.copy(alpha = 0.5f)

    val activeIndicatorColor = if (isDarkTheme) Purple700 else Purple500
    val inactiveIndicatorColor = if (isDarkTheme) LightGray else DarkGray

    val pages = listOf(OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third)

    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size // Provide the total count dynamically
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(10f),
            verticalAlignment = Alignment.CenterVertically
        ) { position ->
            PagerScreen(
                onBoardingPage = pages[position],
                titleColor = titleColor,
                descriptionColor = descriptionColor
            )
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            pageCount = pages.size,
            activeColor = activeIndicatorColor,
            inactiveColor = inactiveIndicatorColor
        )

        AnimatedVisibility(
            visible = pagerState.currentPage == pages.lastIndex,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            enter = fadeIn()
        ) {
            Button(
                onClick = { navController.navigate("") },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "Finish")
            }
        }
    }
}

@Composable
fun HorizontalPagerIndicator(
    pagerState: PagerState,
    pageCount: Int,
    activeColor: Color,
    inactiveColor: Color,
    modifier: Modifier = Modifier,
    indicatorSize: Dp = 20.dp,
    indicatorSpacing: Dp = 6.dp
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until pageCount) {
            val color = if (pagerState.currentPage == i) activeColor else inactiveColor
            Box(
                modifier = Modifier
                    .size(indicatorSize)
                    .padding(horizontal = indicatorSpacing / 2)
                    .background(color = color, shape = CircleShape)
            )
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage, titleColor: Color, descriptionColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image"
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = onBoardingPage.title,
            color = titleColor,
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.discription,
            color = descriptionColor,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }
}



// Constants for padding
val EXTRA_LARGE_PADDING = 16.dp
val SMALL_PADDING = 8.dp

// Colors for dark/light themes
val LightGray = Color(0xFFD3D3D3)
val DarkGray = Color(0xFF333333)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)

@Composable
@Preview(showBackground = true)
fun FirstOnBoardingScreenPreview()
{
    Column(modifier=Modifier.fillMaxSize()){
      PagerScreen(onBoardingPage = OnBoardingPage.First, titleColor = DarkGray, descriptionColor = DarkGray)
    }
}

@Composable
@Preview(showBackground = true)
fun SecondOnBoardingScreenPreview()
{
    Column(modifier=Modifier.fillMaxSize()){
        PagerScreen(onBoardingPage = OnBoardingPage.Second, titleColor = DarkGray, descriptionColor = DarkGray)
    }
}

@Composable
@Preview(showBackground = true)
fun ThirdOnBoardingScreenPreview()
{
    Column(modifier=Modifier.fillMaxSize()){
        PagerScreen(onBoardingPage = OnBoardingPage.Third, titleColor = DarkGray, descriptionColor = DarkGray)
    }
}