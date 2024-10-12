package com.example.boycottapp.presentation.suggestion_page_view.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boycottapp.R
import com.example.boycottapp.ui.theme.AcikMaviGonder

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SuggestionPageView(
    onBackPresed: () -> Unit,
) {
    val markaName = remember { mutableStateOf("") }
    val ePosta = remember { mutableStateOf("") }
    val message = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        IconButton(onClick = { onBackPresed() }) {
                            Icon(painter = painterResource(id = R.drawable.back), contentDescription = "")
                        }
                        Text(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            text = "Marka Öner"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(16.dp),

                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Marka Öner",
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = markaName.value,
                            onValueChange = { markaName.value = it },
                            leadingIcon = {
                                Image(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(RoundedCornerShape(15.dp)),
                                    painter = painterResource(id = R.drawable.unlem),
                                    contentDescription = ""
                                )
                            },
                            placeholder = { Text(text = "Marka adı giriniz") },
                            shape = RoundedCornerShape(12.dp),
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = ePosta.value,
                            onValueChange = { ePosta.value = it },
                            leadingIcon = {
                                Image(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(RoundedCornerShape(15.dp)),
                                    painter = painterResource(id = R.drawable.mailll),
                                    contentDescription = ""
                                )
                            },
                            placeholder = { Text(text = "E posta giriniz") },
                            shape = RoundedCornerShape(12.dp),
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = message.value,
                            onValueChange = { message.value = it },
                            leadingIcon = {
                                Image(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(RoundedCornerShape(15.dp)),
                                    painter = painterResource(id = R.drawable.oneri),
                                    contentDescription = ""
                                )
                            },
                            placeholder = { Text(text = "Mesajınızı Giriniz") },
                            shape = RoundedCornerShape(12.dp),
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = AcikMaviGonder
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            shape = RoundedCornerShape(12.dp),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 20.sp,
                                text = "Gönder"
                            )
                        }
                    }
                }
            }
        }
    )
}
