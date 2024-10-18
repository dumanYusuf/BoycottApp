package com.dumanyusuf.boycottapp.presentation.objection_page_view.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dumanyusuf.boycottapp.R
import com.dumanyusuf.boycottapp.domain.model.UsersNotification
import com.dumanyusuf.boycottapp.presentation.component.CustomTextFieldSuggetionAndObjection
import com.dumanyusuf.boycottapp.presentation.objection_page_view.ObjectionViewModel
import com.dumanyusuf.boycottapp.ui.theme.AcikMaviGonder
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectionPageView(
    onBackPresed: () -> Unit,
    viewModel: ObjectionViewModel= hiltViewModel()
) {
    val markaName = remember { mutableStateOf("") }
    val ePosta = remember { mutableStateOf("") }
    val message = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }
    val snacBarHost= remember { SnackbarHostState() }
    val scope= rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snacBarHost){
                Snackbar(
                    snackbarData = it,
                    containerColor = Color.White,
                    contentColor = AcikMaviGonder,
                )
            }
        },
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
                verticalArrangement = Arrangement.Center
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
                        if (errorMessage.value.isNotEmpty()) {
                            Text(
                                text = errorMessage.value,
                                color = MaterialTheme.colorScheme.error,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                        CustomTextFieldSuggetionAndObjection(
                            value = markaName.value,
                            onValueChange = { markaName.value = it },
                            placeholderText = "Marka adı giriniz",
                            leadingIconResId = R.drawable.unlem,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomTextFieldSuggetionAndObjection(
                            value = ePosta.value,
                            onValueChange = { ePosta.value = it },
                            placeholderText = "Eposta giriniz",
                            leadingIconResId = R.drawable.mailll,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomTextFieldSuggetionAndObjection(
                            value = message.value,
                            onValueChange = { message.value = it },
                            maxLines = 3,
                            placeholderText = "Mesajınızı giriniz",
                            leadingIconResId = R.drawable.oneri,
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
                            onClick = {
                                if (markaName.value.isEmpty() || ePosta.value.isEmpty() || message.value.isEmpty()) {
                                    errorMessage.value = "Lütfen tüm alanları doldurun."
                                } else if (!ePosta.value.contains("@")) {
                                    errorMessage.value = "Lütfen geçerli bir e-posta adresi girin."
                                } else {
                                    val newNote = UsersNotification(
                                        userNotificationId = "",
                                        markaName = markaName.value,
                                        userPosta = ePosta.value,
                                        userMessage = message.value
                                    )
                                    scope.launch {
                                        snacBarHost.showSnackbar(message = "Mesajınız Alındı")
                                    }
                                    viewModel.objectionMessage(newNote)
                                    errorMessage.value = ""
                                    markaName.value=""
                                    ePosta.value=""
                                    message.value=""
                                }
                            }
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