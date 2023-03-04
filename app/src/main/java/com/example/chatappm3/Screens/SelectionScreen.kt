package com.example.chatappm3.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.chatappm3.CustomUI.CustomButton
import com.example.chatappm3.Screen.Screen
import com.example.chatappm3.ui.theme.*

@Preview(showBackground = true)
@Composable
fun PreviewSelectionScreen() {
}

@Composable
fun SelectionScreen(
    navHostController: NavHostController
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomButton(
            text = "SERVER",
            textColor = MaterialTheme.colorScheme.primary,
            boxModifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .weight(1f)
                .clickable {
                    navHostController.navigate(route = Screen.List.passId(1))
                }
        )
        CustomButton(
            text = "CLIENT",
            textColor = MaterialTheme.colorScheme.primaryContainer,
            boxModifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primary)
                .weight(1f)
                .clickable {
                    navHostController.navigate(route = Screen.List.passId(0))
                }
        )
    }
}