package com.dumanyusuf.boycottapp.presentation.contact_us_page_view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dumanyusuf.boycottapp.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContactUsePageView(
    onBackPresed:()->Unit
) {
    val context= LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        IconButton(
                            onClick = { onBackPresed() }
                        ) {
                            Icon(painter = painterResource(id = R.drawable.back), contentDescription = "")
                        }
                        Text(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            text = "Bize Ulaş"
                        )
                    }
                }
            )
        },
        content = {innerPadding->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                   Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                       Image(
                           modifier = Modifier.size(50.dp),
                           painter = painterResource(id = R.drawable.mailll), contentDescription = "")
                       Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                       Text(
                           color = MaterialTheme.colorScheme.onBackground,
                           fontSize = 24.sp,
                           fontWeight = FontWeight.Bold,
                           text = "Mail Adresi")
                   }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:dumannyusuf65@gmail.com")
                                putExtra(Intent.EXTRA_SUBJECT, "Subject here")
                            }
                            context.startActivity(intent)
                        },
                        text = "dumannyusuf65@gmail.com"
                    )
                    Spacer(modifier = Modifier.padding(15.dp))
                   Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                       Image(
                           modifier = Modifier.size(50.dp),
                           painter = painterResource(id = R.drawable.phone), contentDescription = "")
                       Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                       Text(
                           color = MaterialTheme.colorScheme.onBackground,
                           fontSize = 24.sp,
                           fontWeight = FontWeight.Bold,
                           text = "Telefon Numarası")
                   }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable {
                            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:05468054726")
                            }
                            context.startActivity(phoneIntent)
                        },
                        text = "0546 805 4726"
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
        }
    )

}