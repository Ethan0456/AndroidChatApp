package com.example.chatappm3.CustomUI

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    text: String = "Button",
    textColor: Color = Color.Black,
    boxModifier: Modifier,
) {
    Box(
        modifier = boxModifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = text,
            color = textColor,
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 40.sp
            )
        )
    }
}