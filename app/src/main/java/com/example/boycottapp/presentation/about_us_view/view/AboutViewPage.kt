package com.example.boycottapp.presentation.about_us_view.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.boycottapp.R
import com.example.boycottapp.Screan


@Composable
fun AboutPageView(
    navController: NavController
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                text = "Hesabım")

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .size(250.dp)) {
                Text(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp),
                    text = "Genel")
                Row(
                    modifier = Modifier.clickable {
                        navController.navigate(Screan.AboutAppPageView.route)
                    },
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.hakimizzzz),
                        contentDescription = "")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        text = "Hakkımızda")
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier.clickable {
                        navController.navigate(Screan.PartnerShipPageView.route)
                    },
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.isbirligi),
                        contentDescription = "")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        text = "İş Birliği")
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.bagiss),
                        contentDescription = "")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        text = "Bağış Yap")
                }

            }


            // ikinci card
            Spacer(modifier = Modifier.padding(5.dp))

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .size(320.dp)) {
                Text(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp),
                    text = "İletişim")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.oneri),
                        contentDescription = "")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        text = "Öneri")
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.itiraz),
                        contentDescription = "")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        text = "İtiraz")
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.mailll),
                        contentDescription = "")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        text = "Bize Ulaş")
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.playstore),
                        contentDescription = "")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        text = "Uygulamayı Paylaş")
                }

            }
        }
    }

}