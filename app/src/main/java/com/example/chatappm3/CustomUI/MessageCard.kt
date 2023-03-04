package com.example.chatappm3.CustomUI

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewMessage() {
    MessageCard(
        Message("Hi", "Hi How Are You?Hi How Are You?Hi How Are You?Hi How Are You?Hi How Are You?Hi How Are You?Hi How Are You?Hi How Are You?Hi How Are You?Hi How Are You?Hi How Are You?", 1),1
    )
}

@Preview
@Composable
fun PreviewMessage1() {
    MessageCard(
        Message("Hi", "Hi How Are You?",0),0
    )
}


@Composable
fun MessageCard(
    message: Message,
    messageSide: Int = 0
) {
    val isDarkTheme = isSystemInDarkTheme()
    val messageSenderColor = if (isDarkTheme) {
        Color.White
    } else {
        Color.Black
    }
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .padding(5.dp)
            .wrapContentHeight()
    ) {
        if (messageSide == 0) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .wrapContentWidth(),
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.primaryContainer)
                            .wrapContentHeight()
                            .widthIn(0.dp, (2*LocalConfiguration.current.screenWidthDp.toInt()/3).dp)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = message.messageSender,
                            Modifier.padding(bottom = 5.dp),
                            color = messageSenderColor,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = message.messageText,
                            color = if (isSystemInDarkTheme()) {
                                Color.White
                            } else {
                                Color.Black
                            },
                            overflow = TextOverflow.Visible
                        )
                    }

                }
                Column(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                ) {

                }
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background),
                ) {

                }
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .wrapContentWidth(),
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.primaryContainer)
                            .wrapContentHeight()
                            .widthIn(0.dp, (2*LocalConfiguration.current.screenWidthDp.toInt()/3).dp)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = message.messageSender,
                            Modifier.padding(bottom = 5.dp),
                            color = messageSenderColor,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = message.messageText,
                            color = if (isSystemInDarkTheme()) {
                                Color.White
                            } else {
                                Color.Black
                            },
                            overflow = TextOverflow.Visible
                        )
                    }

                }
            }
        }
    }
}