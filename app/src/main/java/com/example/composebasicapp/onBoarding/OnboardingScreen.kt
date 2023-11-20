package com.example.composebasicapp.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasicapp.R
import com.example.composebasicapp.common.Routes
import com.example.composebasicapp.ui.theme.Blue
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme


@Composable
fun OnBoardingScreen(
    viewModel: OnboardingViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigateNext: (String) -> Unit,
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            ),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            modifier = Modifier
                .padding(
                    start = 48.dp,
                    end = 48.dp,
                    top = 16.dp,
                )
                .graphicsLayer {
                    alpha = 0.99f
                }
                .drawWithContent {
                    val colors = listOf(
                        Color.Transparent,
                        Color.Transparent,
                        Color.Transparent,
                        Color.White
                    )
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                        blendMode = BlendMode.DstOut
                    )
                },
            painter = painterResource(id = uiState.getSelectedItem().imageId),
            contentDescription = null
        )

        // Bottom Container
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Blue,
                    shape = RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp
                    )
                )
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                text = uiState.getSelectedItem().title,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = uiState.getSelectedItem().description,
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Skip",
                    color = Color.White.copy(
                        if (uiState.selectedItem == 0)
                            0.50f
                        else
                            1f
                    )
                )
                Row() {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = Color.White.copy(
                                    if (uiState.selectedItem == 0)
                                        1f
                                    else
                                        0.20f
                                ),
                                shape = CircleShape,
                            )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = Color.White.copy(
                                    if (uiState.selectedItem == 1)
                                        1f
                                    else
                                        0.20f
                                ),
                                shape = CircleShape,
                            )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = Color.White.copy(
                                    if (uiState.selectedItem == 2)
                                        1f
                                    else
                                        0.20f
                                ),
                                shape = CircleShape,
                            )
                    )
                }
                Text(
                    modifier = Modifier
                        .clickable {
                            val shouldNavigateNext =  viewModel.moveNext()
                            if (shouldNavigateNext)
                                navigateNext(Routes.signIn)
                        },
                    text = "Next",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }


}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    ComposeBasicAppTheme {
        OnBoardingScreen() {

        }
    }
}

