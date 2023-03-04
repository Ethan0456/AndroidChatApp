package com.example.chatappm3.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatappm3.CustomUI.CustomTextField
import kotlinx.coroutines.*

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
//    LoginScreen(
//        viewModel = AppViewModel(),
//        navHostController = NavHostController(),
//        server = 0
//    )
}

@Composable
fun LoginScreen(
    viewModel: AppViewModel,
    navHostController: NavHostController,
    server: Int
) {
    val ip: String by viewModel.ip.observeAsState("")
    val port: String by viewModel.port.observeAsState("")
    val username: String by viewModel.username.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 50.dp,
                end = 50.dp,
                bottom = 50.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(color = MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "CHATAPP",
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.primary),
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }

        }

        if (server != 1) {
            CustomTextField(
                value = ip,
                onValueChange = { viewModel.onIpChanged(it) },
                placeholder = { Text(text = "888.888.888.888") },
                label = { Text(text = "IP Address") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
            )
        }


        CustomTextField(
            value = port,
            onValueChange = { viewModel.onPortChanged(it) },
            placeholder = { Text(text = "88888") },
            label = { Text(text = "Port Number") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
        )

        CustomTextField(
            value = username,
            onValueChange = { viewModel.onUsernameChanged(it) },
            placeholder = { Text(text = "Username") },
            label = { Text(text = "Username") },
            maxLines = 1
        )

        Button(
            onClick = {
                viewModel.onConnectClicked(
                    appViewModel = viewModel,
                    navHostController = navHostController
                )
            }
        ) {
            Text(text = "Connect")
        }
    }
}