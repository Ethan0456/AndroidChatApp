package com.example.chatappm3.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.chatappm3.CustomUI.MessageCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun PreviewChatScreen() {
}

@Composable
fun ChatScreen(
    viewModel: AppViewModel,
    navHostController: NavHostController
) {

    var text by remember { mutableStateOf("") }
    var listOfChats = viewModel.repository.chatHist.observeAsState()
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(9f)
        ) {
            items(
                items=listOfChats.value!!.toList()
            ) {
                msg -> MessageCard(message = msg,msg.i)
            }
        }
        Row {
            OutlinedTextField(
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults
                    .outlinedTextFieldColors(
                        unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                        focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                        focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedLabelColor = Color.White,
                        cursorColor = MaterialTheme.colorScheme.primaryContainer,
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                value = text,
                onValueChange = { text = it },
                trailingIcon = {
                    if (text.isNotBlank()) {
                        IconButton(onClick = {
                            CoroutineScope(Dispatchers.IO).launch {
                                viewModel.repository.write(viewModel.username.value.toString(),text)
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
                        }
                    }
                }
            )
        }
    }
}