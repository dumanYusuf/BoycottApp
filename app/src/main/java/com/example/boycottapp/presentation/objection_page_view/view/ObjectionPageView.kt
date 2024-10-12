package com.example.boycottapp.presentation.objection_page_view.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boycottapp.R
import com.example.boycottapp.ui.theme.AcikKirmizi
import com.example.boycottapp.ui.theme.AcikMaviGonder


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectionPageView(
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
                            text = "Marka İtiraz"
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
                            text = "Marka İtiraz",
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
                                    painter = painterResource(id = R.drawable.kirmiziunlem),
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
                                    painter = painterResource(id = R.drawable.kirmizieposta),
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
                                    painter = painterResource(id = R.drawable.kirmizimessage),
                                    contentDescription = ""
                                )
                            },
                            placeholder = { Text(text = "Mesajınızı Giriniz") },
                            shape = RoundedCornerShape(12.dp),
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = AcikKirmizi
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