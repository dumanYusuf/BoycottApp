package com.example.boycottapp.presentation.partner_ship_page_view

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boycottapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartnerShipPageView(
    onBackPressed: () -> Unit,
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
                            onClick = { onBackPressed() }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.back),
                                contentDescription = "Geri Dön",
                            )
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
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    lineHeight = 28.sp,
                    text = "Uygulamamız, sosyal sorumluluk projeleri, sürdürülebilirlik çalışmaları ve etik ticaretle ilgili faaliyet gösteren kurumlarla iş birliği yaparak kullanıcılarımızı bilinçlendirmeyi hedefler. Şirketiniz ya da topluluğunuzun çevresel ve toplumsal değerlerine uygun projelerle bir araya gelerek, tüketici bilincini artırma yolunda birlikte adım atabiliriz."
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    text = "İletişim Bilgileri"
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.mailll),
                        contentDescription = "Email",
                     )
                    Spacer(modifier = Modifier.width(8.dp))
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
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    text = "İş birliği fırsatları ve önerileriniz için bizimle iletişime geçmekten çekinmeyin.",
                    fontWeight = FontWeight.Medium
                )
            }
        }
    )
}
