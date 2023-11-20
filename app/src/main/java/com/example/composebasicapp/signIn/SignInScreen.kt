package com.example.composebasicapp.signIn

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasicapp.R
import com.example.composebasicapp.common.Routes
import com.example.composebasicapp.ui.theme.Black1
import com.example.composebasicapp.ui.theme.Blue
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme
import com.example.composebasicapp.ui.theme.Gray
import com.example.composebasicapp.ui.theme.Gray1
import com.example.composebasicapp.ui.theme.Gray2
import com.example.composebasicapp.ui.theme.Gray3
import com.example.composebasicapp.ui.theme.Gray4
import com.example.composebasicapp.ui.theme.Gray5

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    viewModel: SignInViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigateNext: (String) -> Unit,
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            modifier = Modifier
                .size(58.dp),
            painter = painterResource(id = R.drawable.app_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "EventHub",
            color = Gray,
            fontSize = 35.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = "Sign in",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Black1,
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.email,
                onValueChange = {
                    viewModel.updateEmail(it)
                },
                placeholder = {
                    Text("abc@gmail.com")
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .clickable { },
                        painter = painterResource(id = R.drawable.email_icon),
                        contentDescription = null,
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Gray1,
                    placeholderColor = Gray2,
                    unfocusedLeadingIconColor = Gray3,
                ),
                shape = RoundedCornerShape(12.dp)

            )

            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.password,
                onValueChange = {
                    viewModel.updatePassword(it)
                },
                placeholder = {
                    Text("Your password")
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(22.dp),
                        painter = painterResource(id = R.drawable.lock_icon),
                        contentDescription = null,
                    )
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .clickable {
                                viewModel.updatePasswordVisibility(!uiState.passwordVisibility)
                            },
                        painter = painterResource(
                            if (!uiState.passwordVisibility)
                                R.drawable.visibility_off_icon
                            else
                                R.drawable.baseline_visibility_24
                        ),
                        contentDescription = null,
                        tint = Gray4
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Gray1,
                    placeholderColor = Gray2,
                    unfocusedLeadingIconColor = Gray3,
                ),
                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (!uiState.passwordVisibility)
                    PasswordVisualTransformation()
                else
                    VisualTransformation.None
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Switch(
                    checked = uiState.rememberMeCheck,
                    onCheckedChange = {
                        viewModel.updateRememberMeCheck(it)
                    },
                    colors = SwitchDefaults.colors(
                        checkedTrackColor = Blue
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Remember Me",
                    fontSize = 14.sp,
                    color = Black1,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Forgot Password?",
                    fontSize = 14.sp,
                    color = Black1,
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(58.dp),
            onClick = {
                viewModel.signInOnClick()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 16.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "SIGN IN",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.arrow_right_icon),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "OR",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Gray5,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(58.dp),
            onClick = {
                viewModel.loginWithGoogleOnClick()
            },
            colors = ButtonDefaults.buttonColors(
//                containerColor = Blue.copy(0.2f),
                containerColor = Color.White,
                contentColor = Black1
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 16.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(18.dp))
                Text(
                    text = "Login with Google",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(58.dp),
            onClick = {
                viewModel.loginWithFacebookOnClick()
            },
            colors = ButtonDefaults.buttonColors(
//                containerColor = Blue.copy(0.2f),
                containerColor = Color.White,
                contentColor = Black1
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 16.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.facebook_icon),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(18.dp))
                Text(
                    text = "Login with Facebook",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 15.sp,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier
                    .clickable {
//                        viewModel.signUpOnClick()
                        navigateNext(Routes.signUp)
                    },
                text = "Sign up",
                fontSize = 15.sp,
                color = Blue
            )

        }


    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    ComposeBasicAppTheme {
        SignInScreen() {

        }
    }
}

