package com.example.composebasicapp.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme

@Composable
fun ConstraintLayoutDemoScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        val (text, greenBox, blueBox, redCircle, yellowBox) = createRefs()

        Text(
            modifier = Modifier
                .constrainAs(text) {
                    this.centerVerticallyTo(parent)
                    this.centerHorizontallyTo(parent)
                },
            text = "Hello In Compose",
            fontSize = 24.sp,
        )

        // Green Box
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(color = Color.Green)
                .constrainAs(greenBox) {
                    end.linkTo(text.start)
                    top.linkTo(text.top)
                    bottom.linkTo(text.bottom)
                }
        )

        // Blue Box
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(color = Color.Blue)
                .constrainAs(blueBox) {
                    top.linkTo(text.bottom)
                    end.linkTo(text.end)
                }
        )

        // Red Circle
        Box(
            modifier = Modifier
                .size(16.dp)
                .background(color = Color.Red, shape = CircleShape)
                .constrainAs(redCircle) {
                    top.linkTo(text.top, 4.dp)
                    end.linkTo(text.end, 25.dp)
                    bottom.linkTo(text.bottom)
                }
        )

        // Yellow Box
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(color = Color.Yellow)
                .constrainAs(yellowBox) {
                    bottom.linkTo(text.top, -8.dp)
                    end.linkTo(text.end)
                    start.linkTo(text.start)
                }

        )

    }
}

@Preview
@Composable
fun ConstraintLayoutDemoScreenPreview() {
    ComposeBasicAppTheme {
        ConstraintLayoutDemoScreen()
    }
}

