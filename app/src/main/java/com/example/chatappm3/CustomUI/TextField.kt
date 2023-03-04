package com.example.chatappm3.CustomUI

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable () -> Unit,
    label: @Composable () -> Unit,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    shape: Shape = RoundedCornerShape(50.dp)
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults
            .outlinedTextFieldColors(
                unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedLabelColor = Color.White,
                cursorColor = MaterialTheme.colorScheme.primaryContainer
            ),
        placeholder = placeholder,
        label = label,
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        shape = shape
    )
}