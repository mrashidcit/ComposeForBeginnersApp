package com.example.composebasicapp.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import com.example.composebasicapp.ui.theme.Blue
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme

@Composable
fun ConstraintLayoutDemoScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        val (text, redBox, greenBox, blueBox, yellowBox) = createRefs()

        Text(
            modifier = Modifier.constrainAs(text) {
                centerHorizontallyTo(parent)
                centerVerticallyTo(parent)
            },
            text  = "Hello Compose",
            fontSize = 24.sp,
        )

        // Red Box
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(color = Color.Red)
                .constrainAs(redBox) {
                    end.linkTo(text.start)
                    top.linkTo(text.top)
                }
        )

        // Green Box
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(color = Color.Green)
                .constrainAs(greenBox) {
                    bottom.linkTo(text.top)
                    start.linkTo(text.start, margin = 15.dp)
                }
        )

        // Blue Box
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(color = Blue)
                .constrainAs(blueBox) {
                    top.linkTo(text.bottom)
                    start.linkTo(text.start)
                    end.linkTo(text.end)
                }

        )

        // Yellow Box
        Box(
            modifier = Modifier
                .size(17.dp)
                .background(color = Color.Yellow, shape = CircleShape)
                .constrainAs(yellowBox) {
                    end.linkTo(text.end, 25.dp)
                    top.linkTo(text.top, 3.dp)
                    bottom.linkTo(text.bottom)
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

