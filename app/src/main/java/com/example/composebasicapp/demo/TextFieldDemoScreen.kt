package com.example.composebasicapp.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasicapp.R
import com.example.composebasicapp.ui.theme.ComposeBasicAppTheme

// State

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDemoScreen() {

    val firstName = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)
    ) {

        // firstName
        TextField(
            value = firstName.value,
            onValueChange = {
                firstName.value = it
            },
            placeholder = {
                Text("FirstName")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))
        // Email
        TextField(
            value = email.value,
            onValueChange =  {
                email.value = it
            },
            placeholder = {
                Text("Email Address")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(12.dp))
        // Password
        TextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            placeholder = {
                Text("Password")
            },
            visualTransformation = if (passwordVisibility.value)
                        VisualTransformation.None
                   else
                        PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clickable {
                            passwordVisibility.value = !passwordVisibility.value
                        },
                    painter = painterResource(id =
                        if (passwordVisibility.value)
                            R.drawable.baseline_visibility_24
                        else
                            R.drawable.baseline_visibility_off_24
                    ),
                    contentDescription = null,
                )
            }
        )

















    }
}

@Preview
@Composable
fun TextFieldDemoScreenPreview() {
    ComposeBasicAppTheme {
        TextFieldDemoScreen()
    }
}

