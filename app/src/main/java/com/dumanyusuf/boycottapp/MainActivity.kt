package com.dumanyusuf.boycottapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.dumanyusuf.boycottapp.presentation.navigation.PageController
import com.dumanyusuf.boycottapp.ui.theme.BoycottAppTheme
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        MobileAds.initialize(this@MainActivity) {}

        setContent {
            BoycottAppTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()) {
                    PageController()
                }
            }
        }
    }
}


@SuppressLint("SuspiciousIndentation")
@Composable
fun BannerAdView(
) {
    val context = LocalContext.current

    // Banner reklamını oluştur

       AndroidView(
           modifier = Modifier
               .fillMaxWidth()
               .padding(5.dp),
           factory = {
               AdView(context).apply {
                   setAdSize(AdSize.BANNER) // adSize burada set ediliyor
                   adUnitId = "ca-app-pub-3993872063354474/9569193909" //  banner kimliği
                   loadAd(AdRequest.Builder().build()) // Reklam yükleme işlemi
               }
           }
       )
}



// uygulama kimliği
// ca-app-pub-3993872063354474~2380969020


// banner kimligi
// ca-app-pub-3993872063354474/9569193909

// test banner kimliği
// ca-app-pub-3940256099942544/6300978111



// uygulama kimliği
// ca-app-pub-3993872063354474~2380969020

// interastelle kimliği
// ca-app-pub-3993872063354474/1642672232