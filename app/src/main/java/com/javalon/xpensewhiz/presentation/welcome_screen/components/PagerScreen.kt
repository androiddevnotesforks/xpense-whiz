package com.javalon.xpensewhiz.presentation.welcome_screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.javalon.xpensewhiz.presentation.ui.theme.GreenAlpha700
import com.javalon.xpensewhiz.presentation.ui.theme.blueText
import com.javalon.xpensewhiz.util.spacing

@Composable
fun PagerScreen(page: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = page.icon),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.6f)
        )
        Text(
            text = page.title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,
            color = blueText,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = page.description,
            textAlign = TextAlign.Center,
            color = blueText,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth(.7f)
        )

    }
}

@ExperimentalPagerApi
@Composable
fun GetStartedButton(modifier: Modifier, pagerState: PagerState, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(.8f)
    ) {
        AnimatedVisibility(
            modifier = modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(onClick = { onClick() }, colors = ButtonDefaults.buttonColors(backgroundColor = GreenAlpha700)) {
                Text(
                    text = "Get started",
                    color = Color.White,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(vertical = MaterialTheme.spacing.extraSmall)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FirstPagerPreview() {
    PagerScreen(page = OnBoardingPage.FirstPage)
}

@Composable
@Preview(showBackground = true)
fun SecondPagerPreview() {
    PagerScreen(page = OnBoardingPage.SecondPage)
}

@Composable
@Preview(showBackground = true)
fun ThirdPagerPreview() {
    PagerScreen(page = OnBoardingPage.ThirdPage)
}