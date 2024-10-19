package com.dumanyusuf.boycottapp.presentation.gemini_page_view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dumanyusuf.boycottapp.R
import com.dumanyusuf.boycottapp.domain.model.Message

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GeminiPageView(
    onBackPressed: () -> Unit,
    viewModel: GeminiViewModel = hiltViewModel()
) {
    val textState = remember { mutableStateOf("") }
    val state = viewModel.messageList

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        IconButton(onClick = { onBackPressed() }) {
                            Icon(painter = painterResource(id = R.drawable.back), contentDescription = "")
                        }
                        Text(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            text = "Chat"
                        )
                    }
                }
            )
        },
        content = {innerPadding->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding).imePadding()) {
                MessageList(messageList = state,"user")
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 80.dp),
                    placeholder = { Text("Chate Sor...") }
                )
                IconButton(
                    modifier = Modifier
                        .padding(bottom = 80.dp),
                    onClick = {
                        Log.d("GeminiPageView", "Sent message: ${textState.value}")
                        viewModel.sendMessage(textState.value)
                        textState.value = ""
                    }
                ) {
                    Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
                }
            }
        }
    )
}


@Composable
fun MessageList(messageList: List<Message>, currentUser: String) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(messageList) { message ->
            val isCurrentUser = message.sender == currentUser

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = if (isCurrentUser) Arrangement.End else Arrangement.Start
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = if (isCurrentUser) Color.Blue else Color.Green
                    ),
                    modifier = Modifier
                        .widthIn(max = 300.dp)
                        .padding(8.dp)
                ) {
                    Text(
                        text = message.message,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

