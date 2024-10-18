package com.dumanyusuf.boycottapp.presentation.donation_page_view
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.dumanyusuf.boycottapp.R
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonationPage(
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
                            text = "Bağış Yap"
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
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    text = "Neden Bağış Gerekli")
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp,
                    text = "Bağış yaparak uygulamanın geliştirilmesine ve daha fazla kişiye ulaşmasına katkıda bulunun")
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp,
                    text = "Ziraat Bankası")
                Row (verticalAlignment = Alignment.CenterVertically){
                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        text = "TR59 0001 0090 1003 4411 505002")
                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = painterResource(id = R.drawable.copy), contentDescription = "")
                }
            }
        }
    )
}