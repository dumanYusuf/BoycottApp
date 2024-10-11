package com.example.boycottapp.presentation.home_page_view.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.example.boycottapp.R
import com.example.boycottapp.presentation.component.CustomTextField
import com.example.boycottapp.presentation.home_page_view.HomePageViewModel
import com.example.boycottapp.ui.theme.AcikKirmizi
import com.example.boycottapp.ui.theme.AcikMavi
import com.example.boycottapp.ui.theme.Purple80


@Composable
fun HomePageView(
    navController: NavController,
    viewModel: HomePageViewModel= hiltViewModel()
) {


    LaunchedEffect(key1 = true) {
        viewModel.loadAllProducts()
    }

    val context= LocalContext.current
    val state=viewModel.state.collectAsState()
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
                onValueChange = {
                    search = it
                    viewModel.searchProduct(it)
                                },
                placeholder = "Marka Ara...",
                leadingIcon = R.drawable.search,
                trailingIcon = R.drawable.clear
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple80
                    ),
                    onClick = {
                        viewModel.loadAllProducts()
                    }) {
                    Text(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        text = "Tümü")
                }
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AcikKirmizi
                    ),
                    onClick = {
                        viewModel.loadFilterProducts("Boykot")
                    }) {
                    Text(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        text = "Boykotlu")
                }
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AcikMavi
                    ),
                    onClick = {
                        viewModel.loadFilterProducts("Uygun")
                    }) {
                    Text(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        text = "Uygun")
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            if (state.value.isLoading) {
                CircularProgressIndicator(
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }
            else{
                if (state.value.productList.isEmpty()){
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            text = "Aradığınız Sonuç Bulunamadı")
                    }
                }
               else{
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 140.dp),
                        columns = GridCells.Fixed(2)) {
                        items(state.value.productList){productList->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                                    .size(250.dp)) {
                                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
                                    Image(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .size(150.dp),
                                        contentScale = ContentScale.Crop,
                                        painter = rememberAsyncImagePainter(model = productList.productImage,
                                            imageLoader = ImageLoader(context) ),
                                        contentDescription ="" )
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Box(
                                        modifier = Modifier
                                            .background(
                                                color = when (productList.productStatus) {
                                                    "Boykot" -> Color.Red.copy(alpha = 0.3f)
                                                    "Uygun" -> Color.Blue.copy(alpha = 0.3f)
                                                    else -> Color.Gray.copy(alpha = 0.3f)
                                                },
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .padding(8.dp)
                                    ) {
                                        Text(
                                            color = when (productList.productStatus) {
                                                "Boykot" -> Color.Red
                                                "Uygun" -> Color.Blue
                                                else -> Color.Black
                                            },
                                            fontSize = 20.sp,
                                            text = productList.productStatus
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Text(
                                        color = MaterialTheme.colorScheme.onBackground,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        text = productList.productName)
                                }
                            }
                        }
                    }
               }
            }
        }
    }

}