package com.example.composebasicapp.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasicapp.R
import com.example.composebasicapp.common.Routes
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme

@Composable
fun SplashScreen(
    navigateNext: (String) -> Unit,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .clickable {
            navigateNext(Routes.onboarding)
        }
        .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.End,
    ) {
        Image(
            modifier = Modifier
                .width(227.dp)
                .height(209.dp),
            painter = painterResource(id = R.drawable.img_top_right_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
//            colorFilter = ColorFilter.tint(Color.Black)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 60.dp) ,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .width(48.dp)
                    .height(50.dp),
                painter = painterResource(id = R.drawable.app_icon),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.img_vent_hub),
                contentDescription = null,
            )
        }

        // Bottom Image backgrounds
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier
                    .width(166.dp)
                    .height(153.dp),
                painter = painterResource(id = R.drawable.img_bottom_left_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
//                colorFilter = ColorFilter.tint(Color.Black)
            )
            Image(
                modifier = Modifier
                    .width(349.dp)
                    .height(322.dp),
                painter = painterResource(id = R.drawable.img_bottom_right_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
//                colorFilter = ColorFilter.tint(Color.Black)
            )
        }


    }

}

@Preview
@Composable
fun ComposeScreenPreview() {
    ComposeBasicAppTheme {
        SplashScreen() {

        }
    }
}



