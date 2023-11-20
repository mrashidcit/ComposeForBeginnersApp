package com.example.composebasicapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composebasicapp.common.Routes
import com.example.composebasicapp.onBoarding.OnBoardingScreen
import com.example.composebasicapp.signIn.SignInScreen
import com.example.composebasicapp.signUp.SignUpScreen
import com.example.composebasicapp.splash.SplashScreen
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            ComposeBasicAppTheme {
                // A surface container using the 'background' color from the theme
//                MainBody()
                NavHost(navController = navController,
                    startDestination = Routes.splash) {

                    composable(Routes.splash) {
                        SplashScreen() {route ->
                            navController.navigate(route)
                        }
                    }

                    composable(Routes.onboarding) {
                        OnBoardingScreen(){route ->
                            navController.navigate(route)
                        }
                    }

                    composable(Routes.signUp) {
                        SignUpScreen(){route ->
                            navController.navigate(route)
                        }
                    }

                    composable(Routes.signIn) {
                        SignInScreen(){route ->
                            navController.navigate(route)
                        }
                    }

                }
            }
        }
    }

    @Composable
    fun MainBody() {
//        Column(
//            modifier = Modifier.fillMaxWidth()
//                .fillMaxHeight()
//                .background(color = Color.Green.copy(alpha = 0.3f) ),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Text(
//                text = "This is my Text",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Green
//            )
//            Button(
//                modifier = Modifier.width(100.dp),
//                onClick = {
//                    Log.d(TAG, "MainBody: buttonClicked")
//                },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color.Red,
//                    contentColor = Color.White,
//                )
//            ) {
//                Text(
//                    text = "Submit",
//                )
//            }
//        }

//        Row(
//            modifier = Modifier
//                .background(color = Color.Green.copy(0.5f))
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly,
//
//        ) {
//            Button(
//                modifier = Modifier.width(100.dp),
//                onClick = {
//                    Log.d(TAG, "MainBody: buttonClicked")
//                },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color.Red,
//                    contentColor = Color.White,
//                )
//            ) {
//                Text(
//                    text = "Submit",
//                )
//            }
//
//            Button(
//                modifier = Modifier.width(100.dp),
//                onClick = {
//                    Log.d(TAG, "MainBody: buttonClicked")
//                },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color.Gray,
//                    contentColor = Color.White,
//                )
//            ) {
//                Text(
//                    text = "Cancel",
//                )
//            }
//        }

        // Icons Code
//        Row(
//            modifier = Modifier
//                .background(Color.White)
//                .fillMaxWidth()
//        ) {
//            Icon(
//                modifier = Modifier.clickable {
//                    Log.d(TAG, "MainBody: person icon clicked")
//                },
//                imageVector = Icons.Default.Person,
//                contentDescription = null,
//            )
//            Spacer(modifier = Modifier.width(10.dp))
//            Icon(
//                modifier = Modifier
//                    .size(40.dp)
//                    .clickable {
//                        Log.d(TAG, "MainBody: plus icon clicked")
//                    }
//,
//                imageVector = Icons.Default.AddCircle,
//                contentDescription = null,
//                tint = Color.Blue
//                )
//            Spacer(modifier = Modifier.width(10.dp))
//            Icon(
//                modifier = Modifier
//                    .size(40.dp)
//                    .clickable {
//                        Log.d(TAG, "MainBody: reaction icon clicked")
//                    }
//                ,
//                painter = painterResource(id = R.drawable.baseline_add_reaction_24),
//                contentDescription = null,
//                tint = Color.Green
//            )
//        }

        // Image code
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.8f,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.img_2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha =1f,
            )

        }




    }

    @Preview
    @Composable
    fun MainBodyPreview() {
        MainBody()
    }

}

