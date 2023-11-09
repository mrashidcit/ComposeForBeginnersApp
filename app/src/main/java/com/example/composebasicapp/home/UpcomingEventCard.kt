package com.example.composebasicapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composebasicapp.R
import com.example.composebasicapp.ui.theme.Blue1
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme
import com.example.composebasicapp.ui.theme.Gray5
import com.example.composebasicapp.ui.theme.Gray6
import com.example.composebasicapp.ui.theme.Gray7
import com.example.composebasicapp.ui.theme.Gray8
import com.example.composebasicapp.ui.theme.Red1
import com.example.composebasicapp.ui.theme.Red2
import com.example.composebasicapp.ui.theme.airbnbCerealBook
import com.example.composebasicapp.ui.theme.airbnbCerealMedium

@Composable
fun UpcomingEventCard() {

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .shadow(8.dp, shape = RoundedCornerShape(18.dp))
            .background(color = Color.White, shape = RoundedCornerShape(18.dp))
            .padding(16.dp)
    ) {

        // Image Container
        ConstraintLayout(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp)),
        ) {

            val (image, dateContainer, bookmarkContainer) = createRefs()

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .constrainAs(image) {

                    },
                painter = painterResource(id = R.drawable.img_upcomingevent_1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            // Date Container
            Column(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(8.dp)
                    .constrainAs(dateContainer) {
                        start.linkTo(parent.start, 10.dp)
                        top.linkTo(parent.top, 10.dp)
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    text = "10",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = Red1,
                )
                Text(
                    text = "JUNE",
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    color = Red1,
                )


            }

            // Bookmark Containers
            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(12.dp)
                    .constrainAs(bookmarkContainer) {
                        top.linkTo(parent.top, 10.dp)
                        end.linkTo(parent.end, 10.dp)
                    }
            ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(id = R.drawable.ic_bookmark_icon),
                    contentDescription = null,
                    tint = Red2,
                )
            }


        }

        // Title Text
        Text(
            modifier = Modifier
                .padding(vertical = 12.dp),
            text = "International Brand Mu....",
            color = Color.Black,
            fontFamily = airbnbCerealMedium,
            fontSize = 18.sp,
        )

        // Going Persons
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
            ) {
                // Image 3
                Image(
                    modifier = Modifier
                        .padding(start = (15 * 2).dp)
                        .size(24.dp)
                    ,
                    painter = painterResource(id = R.drawable.img_avatar_3),
                    contentDescription = null,
                )
                // Image 2
                Image(
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .size(24.dp)
                    ,
                    painter = painterResource(id = R.drawable.img_avatar_2),
                    contentDescription = null,
                )
                // Image 1
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.img_avatar_1),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "+20 Going",
                fontFamily = airbnbCerealMedium,
                fontSize = 12.sp,
                color = Blue1
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_location_marker),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "36 Guild Street London, UK",
                fontFamily = airbnbCerealBook,
                fontSize = 13.sp,
                color = Gray8,
            )
        }


    }





}

@Preview
@Composable
fun UpcomingEventCardPreview() {
    ComposeBasicAppTheme {
        Surface(color = Color.White) {
            UpcomingEventCard()
        }
    }
}

