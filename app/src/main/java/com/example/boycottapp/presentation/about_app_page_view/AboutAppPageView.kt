package com.example.boycottapp.presentation.about_app_page_view

import android.annotation.SuppressLint
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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AboutAppPageView(
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
                            text = "Hakkımızda"
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
                    text = "Bizler, tüketici gücünün farkında olan ve etik olmayan ticari uygulamalara karşı durmayı amaçlayan bir topluluğuz. Boykot uygulamamız, insan hakları, çevre bilinci, hayvan hakları ve adil ticaret gibi konularda duyarlı bireyleri bir araya getirerek, bilinçli tüketim kararları vermelerine yardımcı olmayı hedefler.\n" +
                        "\n" +
                        "Amacımız, toplumu etkileyen büyük şirketlerin sorumsuz davranışlarına karşı tüketici olarak bir ses olabilmek. İster çevresel kirlilik olsun, ister adaletsiz çalışma koşulları, bu uygulama ile birlikte hangi firmaların boykot edildiğini ve neden boykot edildiğini kolayca öğrenebilir ve destekleyebilirsiniz.\n" +
                        "\n" +
                        "Tüketici olarak gücümüz büyük ve bu gücü bilinçli bir şekilde kullanarak, hem kendimize hem de dünyaya daha iyi bir gelecek sağlayabiliriz. Hep birlikte daha sürdürülebilir ve adil bir dünya için harekete geçiyoruz.")
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    modifier = Modifier.padding(10.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Bizi paylaşarak daha fazla kişinin biliçlenmesine yardımcı olun. ")

                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "Sorun ve öneriler için bize ulaşın:")
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "[dumannyusuf65@gmail.com]")
            }
        }
    )

}