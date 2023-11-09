package com.example.composebasicapp.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasicapp.R
import com.example.composebasicapp.ui.theme.Black2
import com.example.composebasicapp.ui.theme.Blue
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme
import com.example.composebasicapp.ui.theme.Gray1
import com.example.composebasicapp.ui.theme.Gray2
import com.example.composebasicapp.ui.theme.Gray3
import com.example.composebasicapp.ui.theme.Gray4

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val confirmPassword = remember {
        mutableStateOf("")
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White)
    ) {

        // Top-Left
        Image(
            painter = painterResource(id = R.drawable.signin_top_left_background),
            contentDescription = null,
        )

        // Top-Right
        Image(
            modifier = Modifier
                .align(Alignment.TopEnd),
            painter = painterResource(id = R.drawable.signin_top_right_background),
            contentDescription = null,
        )

        // Right-Center
        Image(
            modifier = Modifier
                .align(Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.signin_right_center_background),
            contentDescription = null,
        )

        // Bottom-Left
        Image(
            modifier = Modifier
                .align(Alignment.BottomStart),
            painter = painterResource(id = R.drawable.signin_bottom_left_background),
            contentDescription = null,
        )

        // Bottom-Right
        Image(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            painter = painterResource(id = R.drawable.signin_bottom_right_background),
            contentDescription = null,
        )



        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    modifier = Modifier
                        .size(22.dp)
                        .clickable {

                        },
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Sign up",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Black2,
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                placeholder = {
                    Text("Full name")
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(22.dp),
                        painter = painterResource(id = R.drawable.ic_profile_icon),
                        contentDescription = null,
                    )
                },
                shape = RoundedCornerShape(18.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    placeholderColor = Gray1,
                    unfocusedLeadingIconColor = Gray2,
                    unfocusedBorderColor = Gray3
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                placeholder = {
                    Text("abc@gmail.com")
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(22.dp),
                        painter = painterResource(id = R.drawable.email_icon),
                        contentDescription = null,
                    )
                },
                shape = RoundedCornerShape(18.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    placeholderColor = Gray1,
                    unfocusedLeadingIconColor = Gray2,
                    unfocusedBorderColor = Gray3
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                placeholder = {
                    Text("Your password")
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(22.dp),
                        painter = painterResource(id = R.drawable.lock_icon),
                        contentDescription = null,
                    )
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .clickable { },
                        painter = painterResource(id = R.drawable.visibility_off_icon),
                        contentDescription = null,
                    )
                },
                shape = RoundedCornerShape(18.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    placeholderColor = Gray1,
                    unfocusedLeadingIconColor = Gray2,
                    unfocusedBorderColor = Gray3
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = confirmPassword.value,
                onValueChange = {
                    confirmPassword.value = it
                },
                placeholder = {
                    Text("Confirm password")
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(22.dp),
                        painter = painterResource(id = R.drawable.lock_icon),
                        contentDescription = null,
                    )
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .clickable { },
                        painter = painterResource(id = R.drawable.visibility_off_icon),
                        contentDescription = null,
                    )
                },
                shape = RoundedCornerShape(18.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    placeholderColor = Gray1,
                    unfocusedLeadingIconColor = Gray2,
                    unfocusedBorderColor = Gray3
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 14.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        text = "SIGN UP",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_right_arrow_with_blue_background),
                        contentDescription = null,
                    )
                }
            }

            Text(
                modifier = Modifier
                    .padding(vertical = 24.dp),
                text = "OR",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Gray4,
            )

            // Login With Google
            Spacer(modifier = Modifier.height(18.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 14.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_google_icon),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Login with Google",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Black2,
                    )

                }
            }

            // Login With Facebook
            Spacer(modifier = Modifier.height(18.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 14.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_facebook_icon),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Login with Facebook",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Black2,
                    )

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Already have an account?",
                    color = Black2,
                    fontSize = 15.sp,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Signin",
                    fontSize = 15.sp,
                    color = Blue,
                )
            }


        }

    }


}

@Preview
@Composable
fun SignUpScreenPreview() {
    ComposeBasicAppTheme {
        SignUpScreen()
    }
}

