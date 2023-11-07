package com.example.composebasicapp.home.components

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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composebasicapp.R
import com.example.composebasicapp.ui.theme.Blue1
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme
import com.example.composebasicapp.ui.theme.Gray6
import com.example.composebasicapp.ui.theme.Gray7
import com.example.composebasicapp.ui.theme.Orange1
import com.example.composebasicapp.ui.theme.airbnbCerealBlack
import com.example.composebasicapp.ui.theme.airbnbCerealBold
import com.example.composebasicapp.ui.theme.airbnbCerealBook
import com.example.composebasicapp.ui.theme.airbnbCerealExtraBold
import com.example.composebasicapp.ui.theme.airbnbCerealLight
import com.example.composebasicapp.ui.theme.airbnbCerealMedium

@Composable
fun UpComingEventItem(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Orange1,
                shape = RoundedCornerShape(24.dp)
            )
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(16.dp)

    ) {
        ConstraintLayout(
            modifier = Modifier
        ) {

            val (image, date, bookmark) = createRefs()

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .constrainAs(image) { },
                painter = painterResource(id = R.drawable.upcoming_event_1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )


            // Date
            Column(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(vertical = 8.dp, horizontal = 14.dp)
                    .constrainAs(date) {
                        start.linkTo(parent.start, 8.dp)
                        top.linkTo(parent.top, 8.dp)

                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "10",
                    color = Orange1,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )
                Text(
                    text = "JUNE",
                    color = Orange1,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )

            }

            // Bookmark
            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(7.dp))
                    .size(30.dp)
                    .constrainAs(bookmark) {
                        end.linkTo(parent.end, 8.dp)
                        top.linkTo(parent.top, 8.dp)
                    },
            ) {
                Icon(
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_bookmark_icon),
                    contentDescription = null,
                    tint = Orange1
                )

            }
        }
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp),
            text = "Internation Brand Menu is here for you",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        // Going Persons
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {


            Box(modifier = Modifier) {

                // Image 2
                Image(
                    modifier = Modifier
                        .padding(start = (15 * 2).dp)
                        .size(24.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.person_3),
                    contentDescription = null,
                )

                // Image 2
                Image(
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .size(24.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.person_2),
                    contentDescription = null,
                )

                // Image 1
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.person_1),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "+20 Going",
                fontSize = 20.sp,
                color = Blue1,
                fontWeight = FontWeight.Medium,
            )

        }

        Spacer(modifier = Modifier.height(10.dp))
        // Location info
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_location_marker_icon),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "36 Guild Streen London, UK",
                fontFamily = airbnbCerealBook,
                fontSize = 13.sp,
            )

        }


    }
}

@Preview
@Composable
fun UpComingEventItemPreview() {
    ComposeBasicAppTheme {
        Surface(
//            modifier = Modifier
//                .background(color = Gray7)
//                .padding(16.dp),
            color = Gray7
        ) {
            UpComingEventItem()
        }
    }
}

