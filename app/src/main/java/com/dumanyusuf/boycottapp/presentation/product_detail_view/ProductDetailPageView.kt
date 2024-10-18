package com.dumanyusuf.boycottapp.presentation.product_detail_view

import android.annotation.SuppressLint
import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.dumanyusuf.boycottapp.R
import com.dumanyusuf.boycottapp.domain.model.Products

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.style.TextDecoration

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailPageView(
    onBackPresed: () -> Unit,
    products: Products
) {

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                       Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                           IconButton(
                               onClick = { onBackPresed() }
                           ) {
                               Icon(painter = painterResource(id = R.drawable.back), contentDescription = "")
                           }
                           Text(
                               fontSize = 24.sp,
                               fontWeight = FontWeight.Bold,
                               text = products.productName
                           )
                       }
                        IconButton(onClick = {
                            val shareIntent=Intent(Intent.ACTION_SEND).apply{
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, "Check out this product: ${products.productName}")
                            }
                            context.startActivity(
                                Intent.createChooser(shareIntent, "Share via")
                            )
                        }) {
                            Icon(painter = painterResource(id = R.drawable.share), contentDescription ="" )
                        }
                    }

                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                        painter = rememberAsyncImagePainter(
                            model = products.productImage,
                            imageLoader = ImageLoader(context)
                        ),
                        contentDescription = ""
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    Text(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Açıklama"
                    )
                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        fontSize = 20.sp,
                        text = products.productDescription
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                        Text(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            text = "Kaynak"
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        textDecoration = TextDecoration.Underline,
                        text = products.productSupport,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .clickable {
                                if (products.productSupport=="Eklenecek..."){
                                    Toast.makeText(context,"Kaynak Eklenecek...",Toast.LENGTH_SHORT).show()
                                }
                                else{
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(products.productSupport))
                                    context.startActivity(intent)
                                }

                            },
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    )
}


