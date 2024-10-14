package com.example.boycottapp.presentation.home_page_view.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.boycottapp.Screan
import com.example.boycottapp.presentation.component.CustomTextField
import com.example.boycottapp.presentation.home_page_view.HomePageViewModel
import com.google.gson.Gson
import java.net.URLEncoder

@Composable
fun HomePageView(
    navController: NavController,
    viewModel: HomePageViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        //viewModel.loadAllProducts()
        viewModel.loadAllINProducts()
    }

    val context = LocalContext.current
    val state = viewModel.state.collectAsState()
    var search by remember { mutableStateOf("") }
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Icon(
                    tint = Color.Red,
                    painter = painterResource(id = R.drawable.clear),
                    contentDescription = ""
                )
                Text(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "BOYKOT"
                )
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

            TabRow(selectedTabIndex = selectedTabIndex) {
                Tab(
                    selectedContentColor = MaterialTheme.colorScheme.onBackground,
                    selected = selectedTabIndex == 0,
                    onClick = {
                        selectedTabIndex = 0
                        viewModel.loadAllINProducts()
                    },
                    text = { Text("Tümü") }
                )
                Tab(
                    selectedContentColor = MaterialTheme.colorScheme.onBackground,
                    selected = selectedTabIndex == 1,
                    onClick = {
                        selectedTabIndex = 1
                        viewModel.loadFilterProducts("Boykot")
                    },
                    text = { Text("Boykotlu") }
                )
                Tab(
                    selectedContentColor = MaterialTheme.colorScheme.onBackground,
                    selected = selectedTabIndex == 2,
                    onClick = {
                        selectedTabIndex = 2
                        viewModel.loadFilterProducts("Uygun")
                    },
                    text = { Text("Uygun") }
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))

            if (state.value.isLoading) {
                CircularProgressIndicator(
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            } else {
                if (state.value.productList.isEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            text = "Aradığınız Sonuç Bulunamadı"
                        )
                    }
                } else {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 140.dp),
                        columns = GridCells.Fixed(2)
                    ) {
                        items(state.value.productList) { productList ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                                    .size(250.dp)
                                    .clickable {
                                        val productObject = Gson().toJson(productList)
                                        val encodedProductObject =
                                            URLEncoder.encode(productObject, "UTF-8")
                                        navController.navigate(Screan.ProductDetailPageView.route + "/$encodedProductObject")
                                    }
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .size(150.dp),
                                        contentScale = ContentScale.Crop,
                                        painter = rememberAsyncImagePainter(
                                            model = productList.productImage,
                                            imageLoader = ImageLoader(context)
                                        ),
                                        contentDescription = ""
                                    )
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
                                        text = productList.productName
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
