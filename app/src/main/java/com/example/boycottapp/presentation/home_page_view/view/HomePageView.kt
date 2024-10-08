package com.example.boycottapp.presentation.home_page_view.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.boycottapp.R
import com.example.boycottapp.Screan
import com.example.boycottapp.presentation.component.CustomTextField

@Composable
fun HomePageView(
    navController: NavController
) {

    var search by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Icon(
                    tint = Color.Red,
                    painter = painterResource(id = R.drawable.clear), contentDescription ="" )
                Text(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "BOYKOT")
            }
            Spacer(modifier = Modifier.padding(10.dp))
            CustomTextField(
                value = search,
                onValueChange = { search = it },
                placeholder = "Marka Ara...",
                leadingIcon = R.drawable.search,
                trailingIcon = R.drawable.clear,

            )

        }
    }
}