package com.example.boycottapp.presentation.partner_ship_page_view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boycottapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartnerShipPageView(
    onBackPresed: () -> Unit,
) {
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
                            text = "İş Birliği"
                        )
                    }
                }
            )
        },
        content = {innerPadding->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    text = "Uygulamamız, sosyal sorumluluk projeleri, sürdürülebilirlik çalışmaları ve etik ticaretle ilgili faaliyet gösteren kurumlarla iş birliği yaparak kullanıcılarımızı bilinçlendirmeyi hedefler. Şirketiniz ya da topluluğunuzun çevresel ve toplumsal değerlerine uygun projelerle bir araya gelerek, tüketici bilincini artırma yolunda birlikte adım atabiliriz.")
                Spacer(modifier = Modifier.padding(5.dp))

                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    text = "İletişim Bilgileri")
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp,
                    text = "İş birliği için bize ulaşın:\n" +
                        "[dumannyusuf65@gmail.com]")
            }
        }
    )
}